package com.tian.proxy;

import com.tian.bean.Address;
import com.tian.bean.Request;
import com.tian.netty.NettyClient;
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
import io.netty.util.internal.StringUtil;

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
    //一定要是通用  interfaceClass   IHelloService.class
    public <T> T create(final Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass}, new InvocationHandler() {
                    //这里实际上是封装Request请求对象，然后通过Netty发给服务端
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //封装RpcRequest对象---->
                        Request request = getRequestParams(method, args);
                        //服务发现，因为接下来需要进行通信了，IHelloService
                        String serviceName = interfaceClass.getName();
                        //通过负载均衡算法和serviceName获取远程调用的url地址
                        String url = serviceDiscovery.discover(serviceName);
                        //url解析
                        Address address = analyzeAddress(url);
                        if (address == null) {
                            return null;
                        }
                        //发起调用，并收到返回消息
                        return NettyClient.getResponseMsg(request, address.getHost(), address.getPort());
                    }
                });
    }

    /**
     * 请求参数
     */
    private Request getRequestParams(Method method, Object[] args) {
        Request request = new Request();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setTypes(method.getParameterTypes());
        request.setParams(args);
        return request;
    }

    /**
     * 因为我们这里是手写的，所以url是比较交单的127.0.0.1：:880
     * 解析host和ip
     */
    private Address analyzeAddress(String url) {
        if (StringUtil.isNullOrEmpty(url)) {
            return null;
        }
        String[] arrays = url.split(":");
        String host = arrays[0];
        int port = Integer.parseInt(arrays[1]);
        return new Address(host, port);
    }
}
