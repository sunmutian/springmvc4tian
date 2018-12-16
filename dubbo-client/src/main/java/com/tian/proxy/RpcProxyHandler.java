package com.tian.proxy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @auther: tianweichang
 * @date: 2018/12/16 19
 * @Description:
 */
public class RpcProxyHandler extends ChannelInboundHandlerAdapter {

    private Object response;

    public Object getResponse() {
        return response;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //msg:服务端写过来的内容 这里只是简单的操作
        response = msg;
    }
}

