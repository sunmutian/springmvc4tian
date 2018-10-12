package com.tian.config;

import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.validation.filter.ValidationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * dubbo 白名单处理
 *
 * @author tianweichang
 * @date 2018-10-12
 * @see com.alibaba.dubbo.rpc.Filter
 */
public class IpWhiteFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(IpWhiteFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Properties prop = new Properties();
        InputStream in = ValidationFilter.class.getResourceAsStream("/ipWhiteList.properties");
        //客户端ip
        String clientIp = RpcContext.getContext().getRemoteHost();
        try {
            prop.load(in);
            //ip白名单
            String ipwhitelist = prop.getProperty("ipWhiteList");
            if (ipwhitelist.contains(clientIp)) {
                return invoker.invoke(invocation);
            } else {
                return new RpcResult(new Exception("ip地址：" + clientIp + "没有访问权限"));
            }
        } catch (IOException e) {
            LOGGER.error("IO ERROR", e);
        } catch (RpcException e) {
            throw e;
        } catch (Throwable t) {
            throw new RpcException(t.getMessage(), t);
        }
        return invoker.invoke(invocation);
    }
}
