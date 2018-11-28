package com.tian.jvm;

public class StringTest {
    public static void main(String[] args) {
        String aa = "abcd";
        String bb = new String("abcd");


        System.out.println(aa == bb);
        System.out.println(aa.equals(bb));

        String cc = new String("abcd");

        System.out.println(bb == cc);
        System.out.println(bb.equals(cc));

        String dd = new String("abcd").intern();
        String ee = new String("abcd").intern();
        System.out.println(dd == ee);
        System.out.println(dd.equals(ee));

    }
}
