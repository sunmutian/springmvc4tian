package com.tian.pattern.decorator.demo;
/**
 * 添加垂直滚动条功能的第一个混凝土装饰器
 *
 * @author tianwc
 * @date 2018/12/5
 */
class VerticalScrollBarDecorator extends WindowDecorator {
    public VerticalScrollBarDecorator (Window windowToBeDecorated) {
        super(windowToBeDecorated);
    }

    @Override
    public void draw() {
        super.draw();
        drawVerticalScrollBar();
    }

    private void drawVerticalScrollBar() {
        // Draw the vertical scrollbar
    }

    @Override
    public String getDescription() {
        System.out.println("including vertical scrollbars");
        return super.getDescription() + ", including vertical scrollbars";
    }
}
