package com.lotus.jewel.sample.system;

public class TestOfSystem {

	public static void main(String[] args) {

		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				if (status != 5) {
					throw new SecurityException();
				}
			}
		});

		SecurityManager security = System.getSecurityManager();

//		System.exit(1);
		Runtime currentRuntime = Runtime.getRuntime();

		Long maxMemory = currentRuntime.maxMemory();
		System.out.println("max memory : " + maxMemory);

		int availableProcessors = currentRuntime.availableProcessors();
		System.out.println("availableProcessors : " + availableProcessors);

//		currentRuntime.exit(0);

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				System.exit(i);
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}

	}
}
