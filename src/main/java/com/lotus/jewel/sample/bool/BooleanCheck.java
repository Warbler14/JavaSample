package com.lotus.jewel.sample.bool;

import java.util.Random;

public class BooleanCheck {
    public static void main(String[] args) {

       int loop = 100;
       while(loop-- > 0){
           test();
       }

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
