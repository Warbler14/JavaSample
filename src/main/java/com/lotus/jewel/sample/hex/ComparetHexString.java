package com.lotus.jewel.sample.hex;

import java.time.LocalDate;

public class ComparetHexString {

    private static final char[] DIGITS_LOWER_OLD = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    static final char[] DIGITS_LOWER = "0123456789abcdef".toCharArray(); // Unnecessarily redefined for every call.

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        String testString = currentDate.toString();
        System.out.println(testString);
        System.out.println(encodeHexString(testString.getBytes()));
        System.out.println(encodeHexString2(testString.getBytes()));
        System.out.println(bytesToHexString(testString.getBytes()));
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
}
