package com.lotus.jewel.sample.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestOfGenericList {

	public static void main(String[] args) {

	}

	public static void test01() {
		List<? extends Number> list1 = new ArrayList<Integer>();
		list1.add(null); // OK
		Number n = list1.get(0); // OK
		Serializable s = list1.get(0); // OK
		Object o = list1.get(0); // OK

//		list1.add(2.3); // ERROR
//		list1.add(5); // ERROR
//		list1.add(new Object()); // ERROR
//		Integer i = list1.get(0); // ERROR
	}

	public static void test02() {
		List<? super Number> list2 = new ArrayList<Number>();
		list2.add(null); // OK
		list2.add(2.3); // OK
		list2.add(5); // OK
		Object o = list2.get(0); // OK

//		list2.add(new Object()); // ERROR
//		Number n = list2.get(0); // ERROR
//		Serializable s = list2.get(0); // ERROR
//		Integer i = list2.get(0); // ERROR
	}
}
