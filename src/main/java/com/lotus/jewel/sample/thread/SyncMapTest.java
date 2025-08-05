package com.lotus.jewel.sample.thread;

import java.util.HashMap;
import java.util.Map;

public class SyncMapTest {
	public static Map<String, String> map = new HashMap<>();

	public final static String WAIT_CODE = "wait";

	public static void main(String[] args) {

		new MyThread("firstJob", WAIT_CODE).start();
		new MyThread("secondJob", "free").start();

	}

	public static Map<String, String> getMap(String codeName) {
		synchronized (map) {
			System.out.println(codeName + " request");
			return map;
		}
	}

	public static class MyThread extends Thread {

		private final String jobName;

		private final String codeName;

		public MyThread(String jobName, String codeName) {
			super();
			this.jobName = jobName;
			this.codeName = codeName;
		}

		@Override
		public void run() {
			long startTime = System.currentTimeMillis();
			System.out.println(jobName + " start");

			Map<String, String> theMap = getMap(codeName);

			if (WAIT_CODE.equals(codeName)) {
				try {
					final long sleepTime = 3000;
					System.out.println("sleep " + sleepTime);
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}

			theMap.put(jobName, "jobName touched");
			System.out.println(jobName + " " + map.size() + " " + theMap.size());


			System.out.println(jobName + " end " + (System.currentTimeMillis() - startTime));
		}
	}

}
