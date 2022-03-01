package com.lotus.jewel.sample.system;

import java.util.Properties;
import java.util.Set;

public class TestOfProperty {

	public static void main(String[] args) {
		
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		
		System.out.println("OS name " + osName);
		System.out.println("User name " + userName);
		System.out.println("User home " + userHome);
		
		Properties props = System.getProperties();
		Set<Object> keys = props.keySet();
		
		for (Object object : keys) {
			String key = String.valueOf(object);
			String value = System.getProperty(key);
			System.out.println("key : " + key + ", value : " + value);
		}
	}
}
