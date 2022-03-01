package com.lotus.jewel.sample.map;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Set;

public class HashtableBasic {

	public HashtableBasic() {
		super();
		System.out.println("----- Hashtable Basic -----");
	}

	public void test01() {
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		table.put(0, Calendar.SUNDAY);
		table.put(1, Calendar.SUNDAY);
		table.put(2, Calendar.MONDAY);
		table.put(3, Calendar.MONDAY);
		table.put(4, Calendar.WEDNESDAY);
		table.put(5, Calendar.THURSDAY);
		table.put(6, Calendar.FRIDAY);
		table.put(7, Calendar.SATURDAY);
		
		table.replace(3, Calendar.TUESDAY);
		table.remove(0);
		
		Set<Integer> keys = table.keySet();
		for (Integer key : keys) {
			System.out.println("key : " + key + ", value : " + table.get(key));
		}
		
	}
}
