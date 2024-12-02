package com.lotus.jewel.sample.javascript;

import javax.script.*;
public class NashornTest {
    public static void main(String[] args) {

        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            engine.eval("print('Hello from JavaScript!');");
        } catch (Exception e) {
            e.printStackTrace();
            //You can also see that JavaScript was removed in Java 15, as documented in the JDK 15 Release Notes:
            //  https://www.oracle.com/java/technologies/javase/15-relnote-issues.html#JDK-8236933

//            ➜ Removal of Nashorn JavaScript Engine
//            The Nashorn JavaScript script engine, its APIs, and the jjs tool have been removed. The engine, the APIs, and the tool were deprecated for removal in Java 11 with the express intent to remove them in a future release.


        }


    }
}
