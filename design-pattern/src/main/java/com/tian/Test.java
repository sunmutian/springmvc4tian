package com.tian;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianweichang
 * @date 2018-08-28 10:59
 **/
public class Test {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add(null);
        for (String s:list){
            System.out.println(s.length());
        }
    }
}
