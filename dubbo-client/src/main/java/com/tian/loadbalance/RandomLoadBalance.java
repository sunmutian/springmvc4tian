package com.tian.loadbalance;

import java.util.List;
import java.util.Random;

/**
 * @auther: tianweichang
 * @date: 2018/12/15 22
 * @Description: 随机负载均衡算法
 */
public class RandomLoadBalance extends AbstractLoadBalance {
    /**
     * 模板模式--模板方法
     *
     * @param urls 服务地址  127.0.0.1:8080
     * @return
     */
    @Override
    public String select(List<String> urls) {
        if (urls == null || urls.size() == 0) {
            return null;
        }
        return doSelect(urls);
    }

    @Override
    protected String doSelect(List<String> urls) {
        Random random = new Random();
        return urls.get(random.nextInt(urls.size()));
    }
}
