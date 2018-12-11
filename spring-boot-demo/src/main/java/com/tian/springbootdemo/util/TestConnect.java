package com.tian.springbootdemo.util;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 18
 * @Description:
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;

public class TestConnect {
    /*public static void main(String[] args) throws InterruptedException {
        //用于分线程执行完 开始执行主线程 我试的没用
        // CountDownLatch count = new CountDownLatch(500);
        //http连接池
        CloseableHttpClient httpClient;
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(500);
        cm.setDefaultMaxPerRoute(20);
        cm.setDefaultMaxPerRoute(50);
        httpClient = HttpClients.custom().setConnectionManager(cm).build();
        //开启线程
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            myThread1 myThread = new myThread1(i, httpClient);
            Thread thread = new Thread(myThread);
            thread.start();
        }
        // 分线程主线程结束
        //count.await();
        //Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

}

//定义内部变量线程
class myThread1 implements Runnable {

    //传入的参数可以自定义
    private int i;
    CloseableHttpClient httpClient;

    public myThread1() {
    }

    public myThread1(int i, CloseableHttpClient httpClient) {
        super();
        this.i = i;
        this.httpClient = httpClient;
    }


    //线程要执行的方法
    @Override
    public void run() {
        //传入的url
        String url = "http://localhost:8080/sk1";
        HttpPost get = new HttpPost(url);

        //设置表单数据 我们是post请求  get的直接url后加参数
        List<NameValuePair> params = new ArrayList();
        *//*params.add(new BasicNameValuePair("name", "" + i));
        params.add(new BasicNameValuePair("unit", "" + i));
        params.add(new BasicNameValuePair("phone", "" + i));
        params.add(new BasicNameValuePair("jobTitle", "" + i));
        params.add(new BasicNameValuePair("email", "" + i));*//*
        // 转换参数并设置编码格式
        get.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        try {
            //发送请求
            httpClient.execute(get);
            //System.out.println(i); //无法测试什么时候分线程执行完 所以每个分线程执行完打印  但打印不全
        } catch (ClientProtocolException e) {
            System.out.println("fail");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("fail1");
            e.printStackTrace();
        }

    }*/

}

