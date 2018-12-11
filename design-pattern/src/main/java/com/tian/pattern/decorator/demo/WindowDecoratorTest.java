package com.tian.pattern.decorator.demo;

public class WindowDecoratorTest {
    public static void main(String args[]) {
        SimpleWindow simpleWindow = new SimpleWindow();
        VerticalScrollBarDecorator verticalScrollBarDecorator = new VerticalScrollBarDecorator(simpleWindow);
        Window decoratedWindow = new HorizontalScrollBarDecorator(verticalScrollBarDecorator);
        System.out.println(decoratedWindow.getDescription());
    }
}
