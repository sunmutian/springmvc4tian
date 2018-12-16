package com.tian.loadbalance;

import java.util.List;
import java.util.Random;

/**
 * @auther: tianweichang
 * @date: 2018/12/15 22
 * @Description: 随机负载均衡算法
 */
public class RandomLoadBalance implements LoadBalance {
    @Override
    public String select(List<String> urls) {
        Random random = new Random();
        return urls.get(random.nextInt(urls.size()));
    }
}
