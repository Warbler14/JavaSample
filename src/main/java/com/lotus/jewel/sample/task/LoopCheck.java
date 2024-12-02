package com.lotus.jewel.sample.task;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Supplier;

public class LoopCheck {


    public static void main(String[] args) {
        //test1();
        test2();
    }


    public static void test1() {
        // 메서드를 람다로 정의
        List<Supplier<Boolean>> methods = Arrays.asList(
                () -> checkFirst(),
                () -> checkSecond(),
                () -> checkThird()
        );

        // 메서드 실행 결과
        boolean result = executeMethods(methods);

        System.out.println("Final Result: " + result);
    }

    public static void test2() {
        // 메서드를 람다로 정의
        List<Supplier<Boolean>> methods = Arrays.asList(
            () -> {
                System.out.println("Executing checkFirst...");
                return true;
            },
            () -> {
                System.out.println("Executing checkSecond...");
                return true;
            },
            () -> {
                System.out.println("Executing checkThird...");
                return false; // 실패 시뮬레이션
            }
        );

        // 메서드 실행 결과
//        boolean result = executeMethods(methods);

        boolean result = true;
        ListIterator<Supplier<Boolean>> iterator = methods.listIterator();
        while(iterator.hasNext()){
            Supplier<Boolean> method = iterator.next();
            if(Boolean.FALSE.equals(method.get())) {
                result = false;
                break;
            }
        }

        System.out.println("Final Result: " + result);
    }


    // 메서드 목록을 실행하는 로직
    public static boolean executeMethods(List<Supplier<Boolean>> methods) {
        for (Supplier<Boolean> method : methods) {
            if (!method.get()) { // false 반환 시 즉시 중단
                return false;
            }
        }
        return true; // 모두 성공하면 true 반환
    }

    // 개별 메서드 예제
    public static boolean checkFirst() {
        System.out.println("Executing checkFirst...");
        return true;
    }

    public static boolean checkSecond() {
        System.out.println("Executing checkSecond...");
        return true;
    }

    public static boolean checkThird() {
        System.out.println("Executing checkThird...");
        return false; // 실패 시뮬레이션
    }
}
