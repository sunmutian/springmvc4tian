package com.tian.registry;

import com.tian.loadbalance.LoadBalance;
import com.tian.loadbalance.RandomLoadBalance;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: tianweichang
 * @date: 2018/12/15 21
 * @Description: 链接zk，然后把
 */
public class ServiceDiscoveryImpl implements IServiceDiscovery {
    List<String> urls = new ArrayList<>();
    private CuratorFramework curatorFramework;

    {
        //根据ZookeeperConfig中的字符串初始化curatorFramework，链接zk
        curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(ZookeeperConfig.CONNECTION_STR)
                .sessionTimeoutMs(4000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 10))
                .build();
        curatorFramework.start();
    }

    @Override
    public String discover(String serviceName) {
        // /registrys/com.tian.api.IHelloService
        String servicePath = ZookeeperConfig.ZK_REGISTER_PATH + "/" + serviceName;
        try {
            //  /registrys/com.tian.api.IHelloService  --->list
            urls = curatorFramework.getChildren().forPath(servicePath);
            //监听服务是否发生了变化，如果变化了就把变化后的urls更新到本地来
            //负载均衡算法

            //动态感知服务节点的一个变化  zk的监听机制
            registryWatch(servicePath);
            LoadBalance loadBalance = new RandomLoadBalance();
            return loadBalance.select(urls);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private void registryWatch(String servicePath) throws Exception {
        PathChildrenCache childrenCache = new PathChildrenCache(curatorFramework, servicePath, true);
        childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        childrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                switch (event.getType()) {
                    case CHILD_ADDED:
                        urls=client.getChildren().forPath(servicePath);
                        break;
                    case CHILD_UPDATED:
                        urls=client.getChildren().forPath(servicePath);
                        break;
                    case CHILD_REMOVED:
                        urls=client.getChildren().forPath(servicePath);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
