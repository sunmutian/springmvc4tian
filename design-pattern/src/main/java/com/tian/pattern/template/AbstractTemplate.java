package com.tian.pattern.template;

/**
 * 模模板类
 *
 * @Author 小田哥
 * @Date 2018-11-10 15:17
 **/
public abstract class AbstractTemplate {
    /**
     * 算法骨架
     */
    public void templateMethod() {
        this.before();
        this.doSomeThing();
        this.after();
    }

    /**
     * 具体实现类实现
     */
    protected abstract void doSomeThing();

    /**
     * 可以使用父类，也可以在实现类重写
     */
    protected void before() {
        System.out.println("AbstractTemplate before");
    }
    /**
     * 一般方法不行子类实现
     */
    private void after() {
        System.out.println("AbstractTemplate after");
    }
}
