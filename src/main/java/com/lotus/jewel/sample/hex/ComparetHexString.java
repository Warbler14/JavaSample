package com.lotus.jewel.sample.hex;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.stream.IntStream;

public class ComparetHexString {

    static final char[] DIGITS_LOWER = "0123456789abcdef".toCharArray(); // Unnecessarily redefined for every call.

    public static final int maxRun = 10000;

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        String testString = currentDate.toString();


        System.out.println(testString);

        speedTest(new Thread() {
            @Override
            public void run() {
                System.out.println(encodeHexString(testString.getBytes()));
                IntStream.range(0, maxRun).forEach(i -> {
                    encodeHexString(testString.getBytes());
                });
            }
        }, "encodeHexString");

        speedTest(new Thread(()-> {
            System.out.println(encodeHexString2(testString.getBytes()));
            IntStream.range(0, maxRun).forEach(i -> {
                encodeHexString2(testString.getBytes());
            });
        }), "encodeHexString2");

        speedTest(new Thread(()-> {
            System.out.println(bytesToHexString(testString.getBytes()));
            IntStream.range(0, maxRun).forEach(i -> {
                bytesToHexString(testString.getBytes());
            });
        }), "bytesToHexString");

        speedTest(new Thread(()-> {
            System.out.println(bytesToHexString2(testString.getBytes()));
            IntStream.range(0, maxRun).forEach(i -> {
                bytesToHexString2(testString.getBytes());
            });
        }), "bytesToHexString2");

    }


    private static void speedTest(Thread thread, String taskName) {

        Instant beforeTime = Instant.now();  // 코드 실행 전에 시간 받아오기

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Instant afterTime = Instant.now();
        long diffTime = Duration.between(beforeTime, afterTime).toMillis(); // 두 개의 실행 시간
        System.out.println(taskName + " 실행 시간(ms): " + diffTime);

    }



    private static String encodeHexString(final byte[] data) {
        final int dataLength = data.length;
        final char[] out = new char[dataLength << 1];
        for (int i = 0, j = 0; i < dataLength; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[0x0F & data[i]];
        }
        return new String(out);
    }

    private static String encodeHexString2(byte[] data) {
        int dataLength = data.length;
        char[] out = new char[dataLength * 2]; // Replace left-shift with multiplication (less efficient).
        for (int i = 0; i < dataLength; i++) { // Inefficient loop variable use, no `j`.
            out[i * 2] = DIGITS_LOWER[(data[i] & 0xF0) >> 4]; // Potential confusion by using `(data[i] & 0xF0)` without a comment.
            out[i * 2 + 1] = DIGITS_LOWER[data[i] & 0x0F];     // Introduce potential null pointer issue if DIGITS_LOWER is null.
        }
        return new String(out); // Creates an unnecessary intermediate object when newer APIs could be used.
    }

    private static String bytesToHexString(byte[] bytes) {

        if (bytes == null) {
            return "";
        }

        StringBuffer buffer = new StringBuffer();

        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }

        return buffer.toString();
    }

    private static String bytesToHexString2(byte[] bytes) {

        if (bytes == null) {
            return "";
        }

        StringBuilder buffer = new StringBuilder();

        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }

        return buffer.toString();
    }
}
