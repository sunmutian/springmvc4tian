package com.tian.sort.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author tianweichang
 * @date 2018-09-28 10:20
 **/
public class MapQueryDemo {
    private static Map<String, String> DATA = new HashMap<>();

    private static void initMap() {
        for (int i = 0; i < 10000000; i++) {
            DATA.put(String.valueOf(i), "just..");
        }
    }

    public static void main(String[] args) {
        initMap();
//        test1();//33342
//        test2();//35146
//        test3();//32444
//        test4();//30614
        test5();//32339
    }

    /**
     * 通过Map.keySet()key,无法遍历value
     */
    private static void test5() {
        long s = System.currentTimeMillis();
        for (String key : DATA.keySet()) {
            System.out.println(" key: " + key);
        }
        long a = System.currentTimeMillis() - s;
        System.out.println("test5 耗时=" + a);
    }

    /**
     * 通过Map.values()遍历value,无法遍历key
     */
    private static void test4() {
        long s = System.currentTimeMillis();
        for (String value : DATA.values()) {
            System.out.println(" value: " + value);
        }
        long a = System.currentTimeMillis() - s;
        System.out.println("test4 耗时=" + a);
    }

    /**
     * 通过Map.entrySet遍历key和value
     */
    private static void test3() {
        long s = System.currentTimeMillis();
        for (Map.Entry<String, String> entry : DATA.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
        long a = System.currentTimeMillis() - s;
        System.out.println("test3 耗时=" + a);
    }

    /**
     * 通过Map.entrySet使用iterator遍历key和value
     */
    private static void test2() {
        long s = System.currentTimeMillis();
        Iterator<Map.Entry<String, String>> iterator = DATA.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
        long a = System.currentTimeMillis() - s;
        System.out.println("test2 耗时=" + a);
    }

    /**
     * 通过Map.KeySet遍历key和value
     */
    private static void test1() {
        long s = System.currentTimeMillis();
        for (String key : DATA.keySet()) {
            String value = DATA.get(key);
            System.out.println("key: " + key + " value: " + value);
        }
        long a = System.currentTimeMillis() - s;
        System.out.println("test1 耗时=" + a);
    }
}
