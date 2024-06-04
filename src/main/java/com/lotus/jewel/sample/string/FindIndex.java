package com.lotus.jewel.sample.string;

public class FindIndex {

    public static void main(String[] args) {

        String test1 = "www.naver.com";
        String test2 = "*.naver.com";

//        test(test1);
//        test(test2);

        System.out.println(test2.substring(test2.indexOf(".")));
    }

    private static void test(String testString) {
        System.out.println(testString.indexOf("."));
        System.out.println(testString.indexOf(".", 0));
        System.out.println(testString.indexOf(".", 1));
        System.out.println(testString.indexOf(".", 2));
    }
}
