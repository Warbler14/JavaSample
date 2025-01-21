package com.lotus.jewel.sample.instance;

import java.util.HashMap;
import java.util.Map;

public class InstanceNullCheck {
    public static void main(String[] args) {

        printResult(null);
        printResult("aabb");
        printResult(new HashMap<String, String>());

    }

    public static void printResult(Object obj){
        if (obj instanceof String) {
            System.out.println("it is String");
        } else if(obj instanceof HashMap<?,?>) {
            System.out.println("it is HashMap");
        }  else if(obj instanceof Map<?,?>) {
            System.out.println("it is Map");
        } else {
            System.out.println("unknown");
        }
    }
}
