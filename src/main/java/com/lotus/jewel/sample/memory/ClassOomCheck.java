package com.lotus.jewel.sample.memory;

import java.util.ArrayList;

public class ClassOomCheck {

	//출처: https://inpa.tistory.com/entry/JAVA-☕-자바의-내부-클래스는-static-으로-선언하자 [Inpa Dev 👨‍💻:티스토리]

	public static void main(String[] args) {

		final int count = 100000000;
		test1(new OuterClass(count));
		//test1(new OuterStaticInnerClass(count));
	}

	public static void test1(GetObject clazz) {
		ArrayList<Object> list = new ArrayList<>();

		for(int counter = 0 ; counter < 50; counter++ ) {
			// inner_Class 객체를 생성하기 위해 Outer_Class를 초기화하고 메서드를 호출하여 리스트에 넣는다.
			// 이때 Outer_Class 객체는 메소드 호출용으로 일회용으로 사용되고 버려지기 때문에 GC 대상이 되어야 한다.

			list.add(clazz.build().getInnerObject());
			System.out.println(counter);
		}
	}
}
