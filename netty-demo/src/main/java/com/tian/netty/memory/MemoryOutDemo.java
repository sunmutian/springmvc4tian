package com.tian.netty.memory;

import java.util.ArrayList;
import java.util.List;

public class MemoryOutDemo {
    private static List<UserDomain> list=new ArrayList<>();
    public static void main(String[] args) {
      while (true){
          UserDomain userDomain=new UserDomain(1,"test");
          list.add(userDomain);
      }
    }
}
