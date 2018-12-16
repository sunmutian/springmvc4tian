package com.tian.loadbalance;

import java.util.List;

/**
 * @auther: tianweichang
 * @date: 2018/12/16 19
 * @Description:
 */
public abstract class AbstractLoadBalance implements LoadBalance {
    /**
     *
     * @param urls
     * @return
     */
    public String select(List<String> urls) {
        if (urls == null || urls.size() == 0) {
            return null;
        }
        return null;
    }

    //留个具体的实现类实现   模板模式-->钩子方法
    protected abstract String doSelect(List<String> urls);
}
