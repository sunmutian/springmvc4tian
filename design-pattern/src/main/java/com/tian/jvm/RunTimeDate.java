package com.tian.jvm;

/**
 * @auther: lawt
 * @date: 2018/11/11 13
 * @Description: 运行时数据存储
 */
//运行时, jvm 把RunTimeDate的信息都放入---方法区 
public class RunTimeDate {
    //常量
    private static final int ID = 10000;
    private static final String STR="1aw1kkkKKKK";
    //变量
    private static int AGE = 23;
    //Resource
    private MyService myService;//----栈帧中的动态链接

    public void add(){
        int a=0;
        int b=1;
        int c=a+b;
    }
    public synchronized void dd(){
        int a=0;
        int b=1;
        int c=a+b;
    }

    public void cc(){
        synchronized (this) {
            int a = 0;
            int b = 1;
            int c = a + b;
        }
    }
    //main 方法本身放入----方法区
    public static void main(String[] args) {
        int a = 1;
        MyService myService;
        /**
         *  以上args、a、myService放在栈帧中的----局部变量表
         */
        //runTimeDate是引用，所以放到栈区里，
        // new RunTimeDate是自定义对象应该放到---堆
        RunTimeDate runTimeDate = new RunTimeDate();
        //由于test1调用test2了，那么到入栈顺序是怎么样的呢？
        test1();
    }

    private static String test1() {
        test2();
        return "test1返回值";//栈帧中的方法出口
    }

    private static void test2() {
    }
}
