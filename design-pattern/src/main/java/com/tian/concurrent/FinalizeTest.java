package com.tian.concurrent;

/**
 * finalize测试
 *
 * @author tianweichang
 * @date 2018-09-14 9:08
 **/
public class FinalizeTest {
   /* private static FinalizeTest finalizeTest = null;

    public void info() {
        System.out.println("测试资源清理的finalize方法");
    }

    public static void main(String[] args) {
        //创建对象，立即进入可恢复状态
        new FinalizeTest();
        //通知系统进行垃圾回收（通知不一定是立马执行）
        System.gc();
        //强制垃圾回收机调用课恢复对象的finalize方法
//        Runtime.getRuntime().runFinalization();
        System.runFinalization();
        finalizeTest.info();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        finalizeTest = this;
    }*/
}
