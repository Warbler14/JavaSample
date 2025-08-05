package com.lotus.jewel.sample.memory;

public interface GetObject <T> {

	public <T> Object getInnerObject();

	public GetObject build();
}
