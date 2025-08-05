package com.lotus.jewel.sample.system;

public class TestOfSystemProperties {
	public static void main(String[] args) {
		
		System.setProperty("logFilename", "file0");
		
		for (int i = 0 ; i < 10000; i++) {
			
			System.out.println(System.getProperty("logFilename"));
			
			if (i > 10) {
				System.setProperty("logFilename", "file-a");
			}
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}

}
