package com.tian.handler;

import com.tian.bean.Request;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther: lawt
 * @date: 2018/12/16 00
 * @Description: 接收到客户端请求数据并处理
 */
public class RpcHandler extends ChannelInboundHandlerAdapter {
    private Map<String, Object> handlerMap = new HashMap<>();

    public RpcHandler(Map<String, Object> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //   ctx  可以用来向客户端发送数据
        //   msg   可以取到客户端发来的数据
        //获得客户端的传输过来的数据---->RpcRequest序列化反序列化
        Request rpcRequest = (Request) msg;
        System.out.println(rpcRequest);
        Object result = new Object();
        //Client---->使命

        //判断客户端传过来的服务名称在服务端是否存在，存在的话就通过反射进行调用
        if (handlerMap.containsKey(rpcRequest.getClassName())) {
            //用子类对象进行执行
            Object clazz = handlerMap.get(rpcRequest.getClassName());
            Method method = clazz.getClass().getMethod(rpcRequest.getMethodName(), rpcRequest.getTypes());
            //进行调用
            result = method.invoke(clazz, rpcRequest.getParams());
        }
        //写给客户端result结果
        ctx.write(result);
        ctx.flush();
        ctx.close();
    }
}