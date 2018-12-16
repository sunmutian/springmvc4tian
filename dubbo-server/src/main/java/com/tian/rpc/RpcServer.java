package com.tian.rpc;

import com.tian.annotation.Service;
import com.tian.handler.RpcHandler;
import com.tian.registry.IRegistryCenter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther: tianweichang
 * @date: 2018/12/15 23
 * @Description:
 */
public class RpcServer {

    private Map<String, Object> handlerMap = new ConcurrentHashMap<>();

    private IRegistryCenter registryCenter;
    private String serverAddress;

    public RpcServer(IRegistryCenter registryCenter, String serverAddress) {
        this.registryCenter = registryCenter;
        this.serverAddress = serverAddress;
    }

    //把服务名称和实现类一一对应起来
    public void bind(Object... objects) {
        for (Object service : objects) {
            //得到服务名称
            Service anotation = service.getClass().getAnnotation(Service.class);
            //com.tian.service.IHelloService
            String serviceName = anotation.value().getName();
            //最终客户端要根据服务名称调用对应的实现类对象
            handlerMap.put(serviceName, service);
        }
    }

    //发布服务和监听端口
    public void publisher() {
        //1.服务发布
        for (String serviceName : handlerMap.keySet()) {
            //注册服务名称和服务地址
            registryCenter.register(serviceName, serverAddress);
        }
        //2.启动一个监听  Netty   ServerSocket(ip,port);    Socket ----->   监听端口----  IO交互
        try {
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            //启动netty的服务
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel channel) throws Exception {
                    ChannelPipeline pipeline = channel.pipeline();
                    pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                    pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
                    pipeline.addLast("encoder", new ObjectEncoder());
                    pipeline.addLast("decoder", new io.netty.handler.codec.serialization.ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                    //自定义的Handler   IO  无一例外   convention over configuration   约定优于配置、
                    //监听客户端的请求
                    //Spring   Handler   ---->
                    pipeline.addLast(new RpcHandler(handlerMap));
                }
            }).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);
            //通过netty进行监听    8080
            String[] addrs = serverAddress.split(":");
            String ip = addrs[0];
            int port = Integer.parseInt(addrs[1]);
            ChannelFuture future = bootstrap.bind(ip, port).sync();
            System.out.println("netty服务端启动成功，等待客户端的连接:");
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
