package com.lotus.jewel.sample.string;

import java.util.ArrayList;

public class AppendTail {
	public static void main(String[] args) {
		ArrayList<String> targetList = new ArrayList<>();
		System.out.println(toString(targetList));
		targetList.add("A");
		System.out.println(toString(targetList));
		targetList.add("B");
		System.out.println(toString(targetList));
		targetList.add("C");
		System.out.println(toString(targetList));


	}

	public static String toString(ArrayList<String> targetList) {
		StringBuilder builder = new StringBuilder();
		for (int index = 0, limit = targetList.size() - 1; index < targetList.size(); index++) {
			builder.append(targetList.get(index));
			if (index < limit) {
				builder.append(",");
			}
		}
		return builder.toString();
	}
}
