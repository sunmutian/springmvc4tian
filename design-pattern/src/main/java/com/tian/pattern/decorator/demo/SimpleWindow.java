package com.tian.pattern.decorator.demo;

/**
 * 实现一个简单的窗口，没有任何滚动条
 *
 * @author tianwc
 * @date 2018/12/5
 */
public class SimpleWindow implements Window {
    @Override
    public void draw() {
        // Draw window
    }

    @Override
    public String getDescription() {
        System.out.println("simple window");
        return "simple window";
    }
}
