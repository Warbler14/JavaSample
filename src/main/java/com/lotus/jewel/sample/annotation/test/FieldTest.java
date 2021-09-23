package com.lotus.jewel.sample.annotation.test;

import com.lotus.jewel.sample.annotation.StringInjector;

public class FieldTest {

	@StringInjector("My name is cobra")
	private String cobra;
	
	@StringInjector
	private String defaultValue;

	public String getCobra() {
		return cobra;
	}

	public void setCobra(String cobra) {
		this.cobra = cobra;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
}
