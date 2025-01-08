package com.lotus.jewel.sample.memory;

public class OuterStaticInnerClass implements GetObject<OuterStaticInnerClass.InnerClass>{

	private int[] data;

	static class InnerClass {

	}

	public OuterStaticInnerClass(int size) {
		data = new int[size];
	}

	@Override
	public <T> Object getInnerObject() {
		return new OuterStaticInnerClass.InnerClass();
	}

	@Override
	public GetObject build() {
		return new OuterStaticInnerClass(data.length);
	}
}
