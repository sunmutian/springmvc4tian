package com.tian.loadbalance;

import java.util.List;

/**
 * @auther: tianweichang
 * @date: 2018/12/15 22
 * @Description:
 */
public interface LoadBalance {
    //复制均衡算法
    String select(List<String> urls);
}
