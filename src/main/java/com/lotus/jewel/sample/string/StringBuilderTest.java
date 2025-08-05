package com.lotus.jewel.sample.string;

import java.util.Arrays;

public class StringBuilderTest {

    public final static String CACHE_KEY_DELIMITER = "|";

    public static void main(String[] args) {

        System.out.println(makeCacheKey());
        System.out.println(makeCacheKey("a"));
        System.out.println(makeCacheKey((long)10000));
        System.out.println(makeCacheKey("a", "b", "c"));
        System.out.println(makeCacheKey(1, 2, 3));
        System.out.println(makeCacheKey("a", "b", 3));
        System.out.println(makeCacheKey(1, "b", 3));
        System.out.println(makeCacheKey("a", 2, 3));

    }

    public static String makeCacheKey(Object... keys) {
        if (keys.length == 0) {
            return null;
        } else if (keys.length == 1) {
            Object first = Arrays.stream(keys).findFirst();
            return String.valueOf(keys[0]);
        }

        StringBuilder keyBuilder = new StringBuilder();

        for (Object key : keys) {
            if (key == null || key.toString().trim().isEmpty()) {
                return null;
            }

            keyBuilder.append(key).append(CACHE_KEY_DELIMITER);
        }
        keyBuilder.deleteCharAt(keyBuilder.lastIndexOf(CACHE_KEY_DELIMITER));
        return keyBuilder.toString();
    }
}
