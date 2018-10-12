package com.tian.config;

import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.validation.filter.ValidationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IPWhiteFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(IPWhiteFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Properties prop = new Properties();
        InputStream in = ValidationFilter.class.getResourceAsStream("/ipwhitelist.properties");
        //客户端ip
        String clientIp = RpcContext.getContext().getRemoteHost();
        try {
            prop.load(in);
            //ip白名单
            String ipwhitelist = prop.getProperty("ipwhitelist");
            if (ipwhitelist.contains(clientIp)) {
                return invoker.invoke(invocation);
            } else {
                return new RpcResult(new Exception("ip地址："
                        + clientIp + "没有访问权限"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RpcException e) {
            throw e;
        } catch (Throwable t) {
            throw new RpcException(t.getMessage(), t);
        }
        return invoker.invoke(invocation);
    }
}
