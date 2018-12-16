package com.tian.proxy;

import com.tian.bean.Request;
import com.tian.registry.IServiceDiscovery;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther: tianweichang
 * @date: 2018/12/16 13
 * @Description:
 */
public class RpcClientProxy {
    private IServiceDiscovery serviceDiscovery;

    public RpcClientProxy(IServiceDiscovery serviceDiscovery) {
        this.serviceDiscovery = serviceDiscovery;
    }

    //动态代理
    //一定要是通用  interfaceClass   IGpHello.class
    public <T> T create(final Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass}, new InvocationHandler() {
                    //这里实际上是封装RpcRequest请求对象，然后通过Netty发给服务端
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //封装RpcRequest对象---->
                        Request request = new Request();
                        request.setClassName(method.getDeclaringClass().getName());
                        request.setMethodName(method.getName());
                        request.setTypes(method.getParameterTypes());
                        request.setParams(args);

                        //服务发现，因为接下来需要进行通信了，IGpService
                        String serviceName = interfaceClass.getName();
                        //url 地址
                        String serviceAddress = serviceDiscovery.discover(serviceName);

                        //解析host和ip
                        String[] arrs = serviceAddress.split(":");
                        String host = arrs[0];
                        int port = Integer.parseInt(arrs[1]);
                        //Socket   Netty连接   Socket(ip,port)------>Netty
                        //由于是内部类使用所以使用final
                        final RpcProxyHandler rpcProxyHandler = new RpcProxyHandler();
                        //通过netty的方式进行连接和发送
                        //用一个线程组
                        EventLoopGroup group = new NioEventLoopGroup();
                        try {
                            Bootstrap b = new Bootstrap();
                            b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                                    .handler(new ChannelInitializer<SocketChannel>() {
                                        @Override
                                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                                            ChannelPipeline pipeline = socketChannel.pipeline();
                                            pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                                            pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
                                            pipeline.addLast("encoder", new ObjectEncoder());
                                            pipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                                            //使用netty写到最后就是写Handler的代码
                                            pipeline.addLast(rpcProxyHandler);
                                        }
                                    });
                            //连接服务地址
                            ChannelFuture future = b.connect(host, port).sync();
                            //将封装好的request对象--->服务端
                            future.channel().writeAndFlush(request);
                            future.channel().closeFuture().sync();
                        } catch (Exception e) {

                        } finally {
                            group.shutdownGracefully();
                        }
                        //服务端写返回来的数据
                        return rpcProxyHandler.getResponse();
                    }
                });
    }
}
