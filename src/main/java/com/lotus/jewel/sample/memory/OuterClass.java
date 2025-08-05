package com.lotus.jewel.sample.memory;

public class OuterClass implements GetObject<OuterClass.InnerClass> {

	private int[] data;

	class InnerClass {

	}

	public OuterClass(int size) {
		data = new int[size];
	}

	@Override
	public <T> Object getInnerObject() {
		return new OuterClass.InnerClass();
	}

	@Override
	public GetObject build() {
		return new OuterClass(data.length);
	}

}
