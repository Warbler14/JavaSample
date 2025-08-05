package com.lotus.jewel.sample.thread.lock;

import java.util.HashMap;
import java.util.Map;

public class HashmapWrapperLock {

	private final ObjectWrapperLock objectWrapper;
	
	public HashmapWrapperLock() {
		Map<String, String> map = new HashMap<>();
		objectWrapper = new ObjectWrapperLock(map);
	}
	
	public void test() {
		new LockCheckThread(100, objectWrapper, new String[] {"a", "b", "c"}).start();
		new LockCheckThread(100, objectWrapper, new String[] {"1", "2", "3"}).start();
	}
	
	private static class LockCheckThread extends Thread {
		
		private long sleep;
		private ObjectWrapperLock objectWrapper;
		private String[] strings;
		
		public LockCheckThread(long sleep, ObjectWrapperLock objectWrapper, String...strings  ) {
			this.sleep = sleep;
			this.objectWrapper = objectWrapper;
			this.strings = strings;
		}
		
		public void run() {
			String threadName = this.currentThread().getName();
			
			System.out.println("Start thread " + threadName);
			
			Object lockObj = objectWrapper.getLock();
			Object map = objectWrapper.getObject();
			
			synchronized (lockObj) {
				if (map instanceof HashMap) {
					HashMap<String, String> dataMap = (HashMap<String, String>)map;
					
					for (String str : strings) {
						dataMap.put(str, str);
						
						System.out.println( threadName + " " + str);
						try {
							Thread.sleep(sleep);
						} catch (Exception e) {
						}
					}
				}
			}
			
			System.out.println("End thread " + threadName);
			
		}
	}
}
