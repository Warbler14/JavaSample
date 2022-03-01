package com.lotus.jewel.sample.collection.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetBasic {

	public TreeSetBasic() {
		super();
		System.out.println("----- TreeSet Basic -----");
	}

	public void test01() {
		SortedSet<String> cars = new TreeSet<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("BMW");
		cars.add("Mazda");

		cars.addAll(Arrays.asList("Hyundai", "KIA"));

		System.out.println(cars);

		System.out.println("KIA in cars " + cars.contains("KIA"));

	}

	public void test02() {
		List<String> carList = new ArrayList<String>(Arrays.asList("Hyundai", "KIA"));
		carList.add("Volvo");
		carList.add("BMW");
		carList.add("Ford");
		carList.add("BMW");
		carList.add("Mazda");

		NavigableSet<String> cars = new TreeSet<String>(carList);
		
		for(Iterator<String> iter = cars.descendingIterator(); iter.hasNext(); ) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		NavigableSet<String> carsDesc = cars.descendingSet();
		System.out.println(carsDesc);
		
		String first = carsDesc.pollFirst();
		System.out.println(first);
		System.out.println(cars);
		System.out.println(carsDesc);

	}
	
	public void test03() {
		NavigableSet<String> cars1 = new TreeSet<String>(Arrays.asList("Hyundai", "KIA"));
		NavigableSet<String> cars2 = new TreeSet<String>(Arrays.asList("Hyundai", "KIA"));
		NavigableSet<String> cars3 = new TreeSet<String>(Arrays.asList("KIA", "Hyundai"));
		NavigableSet<String> cars4 = new TreeSet<String>(Arrays.asList("KIA", "Hyundai", "GM korea"));
		System.out.println(cars1.equals(cars2));
		System.out.println(cars1.equals(cars3));
		System.out.println(cars1.equals(cars4));
	}

}
