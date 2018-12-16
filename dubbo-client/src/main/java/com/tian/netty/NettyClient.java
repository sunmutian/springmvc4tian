package com.tian.netty;

import com.tian.bean.Request;
import com.tian.proxy.RpcProxyHandler;
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

/**
 * @auther: tianweichang
 * @date: 2018/12/16 20
 * @Description:
 */
public class NettyClient {
    /**
     * 启动一个netty，发起远程调用
     *
     * @param request 请求参数
     * @param host    ip
     * @param port    端口
     * @return 相应结果
     */
    public static Object getResponseMsg(Request request, String host, int port) {
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
                            //编码解码
                            pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                            pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
                            pipeline.addLast("encoder", new ObjectEncoder());
                            pipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                            //使用netty写到最后就是写Handler的代码
                            //handler里处理服务端相应信息
                            pipeline.addLast(rpcProxyHandler);
                        }
                    });
            //连接服务地址
            ChannelFuture future = b.connect(host, port).sync();
            //将封装好的request对象--->服务端
            future.channel().writeAndFlush(request);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
        //服务端写返回来的数据
        return rpcProxyHandler.getResponse();
    }
}
