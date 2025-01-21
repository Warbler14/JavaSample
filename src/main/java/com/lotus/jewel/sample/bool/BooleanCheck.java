package com.lotus.jewel.sample.bool;

import java.util.Random;

public class BooleanCheck {
    public static void main(String[] args) {

//       int loop = 100;
//       while(loop-- > 0){
//           test();
//       }

        test1();

    }

    public static void test1() {
        System.out.println(checker("a"));
        System.out.println(checker("b"));
        System.out.println(checker("c"));
    }

    public static boolean checker(String code) {
        boolean result = true;

        if ("a".equals(code)) {
            result = false;
        } else if ("b".equals(code)) {
            result = false;
        }

        return result;
    }

    public static void test() {
        Boolean b = getBoolean();
        if (Boolean.TRUE.equals(b)) {
            System.out.println("true returns");
        } else {
            System.out.println("false returns");  // will be invoked for both b == false and b == null
        }
    }

    public static Boolean getBoolean() {
        Random random = new Random();
        Integer randomNumber = random.nextInt();
        randomNumber = Math.abs(randomNumber);
        System.out.println(randomNumber + " " + (randomNumber % 3));

        if (randomNumber % 3 == 1) {
            return Boolean.TRUE;
        } else if (randomNumber % 3 == 0) {
            return Boolean.FALSE;
        }

        return null;
    }
}
