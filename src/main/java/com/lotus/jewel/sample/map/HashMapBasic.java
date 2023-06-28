package com.lotus.jewel.sample.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapBasic {

	public HashMapBasic() {
		super();
		System.out.println("----- HashMap Basic -----");
	}

	public void test01() {
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
		table.put(0, Calendar.SUNDAY);
		table.put(1, Calendar.SUNDAY);
		table.put(2, Calendar.MONDAY);
		table.put(3, Calendar.MONDAY);
		table.put(4, Calendar.WEDNESDAY);
		table.put(5, Calendar.THURSDAY);
		table.put(6, Calendar.FRIDAY);
		table.put(7, Calendar.SATURDAY);
		
		HashMap<Integer, Integer> table2 = new HashMap<Integer, Integer>();
		table2.putAll(table);

		table.replace(3, Calendar.TUESDAY);
		table.remove(0);

		printMap(table);
		System.out.println("---");
		printMap(table2);
		
	}
	
	public static void printMap(Map<Integer, Integer> table) {
		Set<Integer> keys = table.keySet();
		for (Integer key : keys) {
			System.out.println("key : " + key + ", value : " + table.get(key));
		}
	}
}
