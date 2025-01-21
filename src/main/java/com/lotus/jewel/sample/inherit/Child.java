package com.lotus.jewel.sample.inherit;

public class Child extends Parent{

    public static void main(String[] args) {
        new Child().myTest();
    }

    public void myTest() {
        test();
    }
}
