package com.tian.registry;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author: lawt
 * @date: 2018/12/15 21
 * @Description: 链接zk，然后把服务注册到注册中心zk上
 */
public class RegistryCenterImpl implements IRegistryCenter {
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
    public void register(String serviceName, String serviceAddress) {

        String servicePath = ZookeeperConfig.ZK_REGISTER_PATH + "/" + serviceName;
        try {
            //判断/registrys/节点是否存在，不存在就创建，持久父节点
            if (curatorFramework.checkExists().forPath(servicePath) == null) {
                curatorFramework.create().creatingParentsIfNeeded()
                        .withMode(CreateMode.PERSISTENT).forPath(servicePath, "0".getBytes());
            }
            String addressPpath = servicePath + "/" + serviceAddress;
            //临时子节点
            String rsNode = curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath(addressPpath, "0".getBytes());
            System.out.println("注册服务节点：" + rsNode);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
