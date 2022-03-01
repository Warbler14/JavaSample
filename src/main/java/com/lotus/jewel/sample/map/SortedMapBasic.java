package com.lotus.jewel.sample.map;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapBasic {

	public SortedMapBasic() {
		super();
		System.out.println("----- SortedMap Basic -----");
	}

	public void test01() {
		SortedMap<Integer, String> sm = new TreeMap<Integer, String>();
		sm.put(new Integer(2), "practice");
		sm.put(new Integer(3), "quiz");
		sm.put(new Integer(5), "code");
		sm.put(new Integer(4), "contribute");
		sm.put(new Integer(1), "geeksforgeeks");
		Set<Entry<Integer, String>> s = sm.entrySet();

		// Using iterator in SortedMap
		Iterator<Entry<Integer, String>> itr = s.iterator();

		// Traversing map. Note that the traversal
		// produced sorted (by keys) output .
		while (itr.hasNext()) {
//			Map.Entry m = (Map.Entry) i.next();
			Entry<Integer, String> entry = itr.next();

			int key = (Integer) entry.getKey();
			String value = (String) entry.getValue();

			System.out.println("Key : " + key + "  value : " + value);
		}
	}

}
