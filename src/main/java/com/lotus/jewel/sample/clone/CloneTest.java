package com.lotus.jewel.sample.clone;

import java.util.Arrays;

public class CloneTest {
	public static void main(String[] args) {
		byteClone();
		stringClone();
		objectClone();
	}

	private static void byteClone() {
		System.out.println("------byteClone------");
		byte[] target = {0,1,2,3};
		print(target);

		byte[] clone = target.clone();
		print(clone);

		byte[] copy = Arrays.copyOf(target, target.length);
		print(copy);

	}

	private static void stringClone() {
		System.out.println("------stringClone------");
		String[] target = {"1", "2", "3", "4"};
		print(target);

		String[] clone = target.clone();
		print(clone);

		String[] copy = Arrays.copyOf(target, target.length);
		print(copy);
	}

	private static void objectClone() {
		System.out.println("------objectClone------");
		Test[] target = {new Test("1"), new Test("2"), new Test("3"), new Test("4")};
		print(target);

		Test[] clone = target.clone();
		print(clone);

		Test[] copy = Arrays.copyOf(target, target.length);
		print(copy);
	}


	private static void print(Object... array) {
		System.out.println(array + " h:" + array.hashCode());
		for(Object item : array) {
			System.out.println(item + " h:" + item.hashCode());
		}
	}

	private static class Test {
		String data;

		public Test(String data) {
			this.data = data;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}
	}
}
