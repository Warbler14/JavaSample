package com.lotus.jewel.sample.collection.list;

import java.util.Arrays;
import java.util.Vector;

public class VectorBasic {

	public VectorBasic() {
		super();
		
		System.out.println("----- Vector Basic -----");
	}

	public void test01 () {
		
		Vector<Integer> vector = new Vector<Integer>(Arrays.asList(1,2,3));
		
		vector.add(4);
		vector.add(null);
		
		vector.remove(4);
		
		System.out.println("vector size " + vector.size());
		
		for (Integer number : vector) {
			System.out.println(number);
		}
	}
	
}
