package com.lotus.jewel.sample.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListBasic {

	public ArrayListBasic() {
		super();
		System.out.println("----- ArrayList Basic -----");
	}

	public void test01 () {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		
		list.add(5);
//		list.add(null);
		list.add(4);
		
		Collections.sort(list);
		
		System.out.println(list);
	}
	
	public void test02 () {
		ArrayList<String> colors = new ArrayList<>();
        // add() method
        colors.add("Black");
        colors.add("White");
        colors.add(0, "Green");
        colors.add("Red");

        // set() method
        colors.set(0, "Blue");

        System.out.println(colors);
	}
	
	public void test03() {
		List<String> carList = Arrays.asList("Hyundai", "KIA");
		carList.add("Volvo");	//java.lang.UnsupportedOperationException
	}
	
	
	public void test04() {
		
		List<String> list01 = new ArrayList<String>();
		list01.add("A");
		list01.add("B");
		list01.add("C");
		list01.add("D");
		list01.add("E");
		
		List<String> list02 = list01;
		
		List<String> list03 = new ArrayList<String>();
		list03.addAll(list01);
		
		list03.set(0, "a");
		list01.set(0, "a!");
		
		System.out.println(list03.get(0));
		
	}
}
