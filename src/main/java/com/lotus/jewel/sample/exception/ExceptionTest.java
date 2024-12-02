package com.lotus.jewel.sample.exception;

public class ExceptionTest {

    public static final String CACHE_KEY_DELIMITER = "|";

    public static void main(String[] args) {

        String data1 = "1";


        System.out.println(check(data1, " "));
        System.out.println(check(data1, "-"));
        System.out.println(check(data1, " - "));

        System.out.println(" - ".trim());
    }

    private static String check(Object ... keys) throws IllegalArgumentException{
        String returnVal = null;
        StringBuilder keyBuilder = new StringBuilder();

        for (Object key : keys) {
            if (key == null || key.toString().trim().isEmpty()) {

                alert();

                return null;
            }

            keyBuilder.append(key).append(CACHE_KEY_DELIMITER);
        }
        keyBuilder.deleteCharAt(keyBuilder.lastIndexOf(CACHE_KEY_DELIMITER));
        returnVal = keyBuilder.toString();

        return returnVal;
    }

    private static void alert() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[3];//maybe this number needs to be corrected
        String methodName = e.getMethodName();

        System.out.println("bad argument from : " + methodName);
    }

    public static boolean hasLength(String str) {
        return (str != null && !str.isEmpty());
    }
}
