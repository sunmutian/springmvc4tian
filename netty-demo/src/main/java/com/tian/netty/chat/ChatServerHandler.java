package com.tian.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;


/**
 * handler处理
 *
 * @author tianweichang
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 任意客户端发过来的数据接收
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        //遍历广播消息
        channelGroup.forEach(ch -> {
            if (channel != ch) {
                //其他用户
                ch.writeAndFlush(channel.remoteAddress() + " 发送的消息：" + msg + "\n");
            } else {
                //自己
                ch.writeAndFlush("【自己】" + msg + "\n");
            }
        });
    }

    /**
     * 新的连接进来
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("【服务器】- " + channel.remoteAddress() + " 加入\n");
        channelGroup.add(channel);
    }

    /**
     * 用户离开
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("【服务器】- " + channel.remoteAddress() + " 离开\n");
        //还剩借个在线
        System.out.println("在线用户数量：" + channelGroup.size());
    }

    /**
     * 用户上线
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 上线");
    }

    /**
     * 用户下线
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 下线");
    }

    /**
     * 异常关闭
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
