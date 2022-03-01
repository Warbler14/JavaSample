package com.lotus.jewel.sample.collection.list;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListBasic {

	public LinkedListBasic() {
		super();
		System.out.println("----- LinkedList Basic -----");
	}

	public void test01 () {
		LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(1,2,3));
		list.addFirst(0);
		list.addLast(4);
		list.add(5);
		list.add(list.size(), 6);
//		list.add(-1, -1);	//java.lang.IndexOutOfBoundsException:
		
		for (Integer number : list) {
			System.out.println(number);
		}
		
		System.out.println("list contains 3 : " + list.contains(3));
		
	}
}
