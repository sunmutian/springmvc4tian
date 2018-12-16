package com.tian.loadbalance;

import java.util.List;

/**
 * @auther: tianweichang
 * @date: 2018/12/16 19
 * @Description: 负载均衡【模板类】
 */
public abstract class AbstractLoadBalance implements LoadBalance {
    /**
     * 模板方法
     */
    public String select(List<String> urls) {
        if (urls == null || urls.size() == 0) {
            return null;
        }
        return null;
    }

    /**
     * 留个具体的实现类实现  【钩子方法】
     */
    protected abstract String doSelect(List<String> urls);
}
