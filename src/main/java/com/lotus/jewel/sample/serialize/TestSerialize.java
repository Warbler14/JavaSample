package com.lotus.jewel.sample.serialize;

import java.io.*;

public class TestSerialize {
    public static void main(String[] args) {

        test0();
//        test1();
//        test2();
//        test3();
//        test4();

    }

    public static void test0() {

        byte [] data = setAttributeValueFromObject("Hello World!");
        Object result = getAttributeValueAsObject(data);

        if (result instanceof String) {
            String check = (String)result;
            System.out.println(check);
        }
    }

    public static void test1() {

        MySerializeObject myObject = new MySerializeObject();
        myObject.setMessage("Hello World!");

        byte [] data = setAttributeValueFromObject(myObject);
        Object result = getAttributeValueAsObject(data);

        if (result instanceof MySerializeObject) {
            MySerializeObject check = (MySerializeObject)result;
            System.out.println(check.getMessage());
        }
    }

    public static void test2() {

        MyNoneSerializeObject myObject = new MyNoneSerializeObject();
        myObject.setMessage("Hello World!");

        byte [] data = setAttributeValueFromObject(myObject);
        Object result = getAttributeValueAsObject(data);

        if (result instanceof MyNoneSerializeObject) {
            MyNoneSerializeObject check = (MyNoneSerializeObject)result;
            System.out.println(check.getMessage());
        }
    }

    public static void test3() {

        MySerializeWrapperObject myWrapperObject = new MySerializeWrapperObject();
        MySerializeObject myObject = new MySerializeObject();
        myObject.setMessage("Hello World!");

        myWrapperObject.setData(myObject);


        byte [] data = setAttributeValueFromObject(myWrapperObject);
        Object result = getAttributeValueAsObject(data);

        if (result instanceof MySerializeWrapperObject) {
            MySerializeWrapperObject check = (MySerializeWrapperObject)result;
            Object origin = check.getData();
            if (origin instanceof MySerializeObject) {
                MySerializeObject originCheck = (MySerializeObject)origin;
                System.out.println(originCheck.getMessage());
            }
        }
    }


    public static void test4() {

        MySerializeWrapperObject myWrapperObject = new MySerializeWrapperObject();
        MyNoneSerializeObject myObject = new MyNoneSerializeObject();
        myObject.setMessage("Hello World!");

        myWrapperObject.setData(myObject);


        byte [] data = setAttributeValueFromObject(myWrapperObject);
        Object result = getAttributeValueAsObject(data);

        if (result instanceof MySerializeWrapperObject) {
            MySerializeWrapperObject check = (MySerializeWrapperObject)result;
            Object origin = check.getData();
            if (origin instanceof MyNoneSerializeObject) {
                MyNoneSerializeObject originCheck = (MyNoneSerializeObject)origin;
                System.out.println(originCheck.getMessage());
            }
        }
    }




    public static Object getAttributeValueAsObject(byte[] attributeValue) {
        InputStream is = new ByteArrayInputStream(attributeValue);
        try (ObjectInput in = new ObjectInputStream(is)) {
            return in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] setAttributeValueFromObject(Object attributeValue) {
        byte[] returnVal = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(attributeValue);
            returnVal = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnVal;
    }

    public static class MySerializeObject implements Serializable {

        private static final long serialVersionUID = -3151407072729898292L;

        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class MyNoneSerializeObject {

        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class MySerializeWrapperObject implements Serializable {

        private static final long serialVersionUID = 9090361122113240308L;
        private Object data;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
