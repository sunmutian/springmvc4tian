package com.tian;

/**
 * @author lawt
 * @date 2019-11-1
 */
public class InitTest1 {
    public static void main(String[] args) {
        Cat cat = new Cat("Java后端技术栈", 21);
        System.out.println(cat);
        Cat cat1 = new Cat("lawt", 23);
        System.out.println(cat1);
    }
}

class Cat {
    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    {
        System.out.println("");
        weight = 2.0;
    }

    double weight = 2.3;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}