package com.lotus.jewel.sample.annotation.test;

import com.lotus.jewel.sample.annotation.MethodAnnotation;

public class MethodTest {
	
	private String message;

	@MethodAnnotation(name = "doThis Method", value = "Hello World")
	public void doThis() {
		
	}
	
	@MethodAnnotation(name = "doThat Mathod")
	public void doThat() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
		
}
