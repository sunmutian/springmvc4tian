package com.tian.pattern.decorator.demo;

public class WindowDecoratorTest {
    public static void main(String args[]) {
        Window decoratedWindow = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));
        // assert that the description indeed includes horizontal + vertical scrollbars
        System.out.println(decoratedWindow.getDescription());
    }
}
