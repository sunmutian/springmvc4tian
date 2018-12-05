package com.tian.pattern.decorator.demo;

/**
 * 实现一个简单的窗口，没有任何滚动条
 *
 * @author tianwc
 * @date 2018/12/5
 */
abstract class WindowDecorator implements Window {
    /**
     * the Window being decorated
     */
    protected Window windowToBeDecorated;

    public WindowDecorator (Window windowToBeDecorated) {
        this.windowToBeDecorated = windowToBeDecorated;
    }
    @Override
    public void draw() {
        windowToBeDecorated.draw(); //Delegation
    }
    @Override
    public String getDescription() {
        //Delegation
        return windowToBeDecorated.getDescription();
    }
}
