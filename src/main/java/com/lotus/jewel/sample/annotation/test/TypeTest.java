package com.lotus.jewel.sample.annotation.test;

import com.lotus.jewel.sample.annotation.TypeAnnotation;

@TypeAnnotation(name = "someName", value = "Hello World")
public class TypeTest {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
