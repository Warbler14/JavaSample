package com.lotus.jewel.sample.collection.set;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetBasic {

	public HashSetBasic() {
		super();
		System.out.println("----- HashSet Basic -----");
	}
	
	public void test01() {
		HashSet<String> cars = new HashSet<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("BMW");
	    cars.add("Mazda");
	    
	    cars.addAll(Arrays.asList("Hyundai", "KIA"));
	    
	    System.out.println(cars);
	    
	    System.out.println("KIA in cars " + cars.contains("KIA"));
		
	}

	
}
