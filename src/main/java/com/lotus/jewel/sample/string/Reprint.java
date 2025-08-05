package com.lotus.jewel.sample.string;

public class Reprint {

    public static void main(String[] args) {

        System.out.print("Hello, World!");

        // Simulate some delay
        slp(1000);

        // Overwrite the last output
        final String word = "Goodbye, World!";

        System.out.print("\r" + word);

        for(char chr : word.toCharArray()) {
            slp(1000);
            System.out.print("\b");
        }

    }

    public static void slp(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
