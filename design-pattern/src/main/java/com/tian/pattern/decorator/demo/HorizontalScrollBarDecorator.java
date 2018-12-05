package com.tian.pattern.decorator.demo;

/**
 * 添加水平滚动条功能的第二个混凝土装饰器
 *
 * @author tianwc
 * @date 2018/12/5
 */
class HorizontalScrollBarDecorator extends WindowDecorator {
    public HorizontalScrollBarDecorator(Window windowToBeDecorated) {
        super(windowToBeDecorated);
    }

    @Override
    public void draw() {
        super.draw();
        drawHorizontalScrollBar();
    }

    private void drawHorizontalScrollBar() {
        // Draw the horizontal scrollbar
    }

    @Override
    public String getDescription() {
        System.out.println("including horizontal scrollbars");
        return super.getDescription() + ", including horizontal scrollbars";
    }
}
