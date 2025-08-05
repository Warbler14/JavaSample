package com.lotus.jewel.sample.thread.lock;

public class ObjectWrapperLock {

	private Object object;
	
	private Object lock = new Object();
	
	public ObjectWrapperLock(Object object) {
		this.object = object;
	}

	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * @return the lock
	 */
	public Object getLock() {
		return lock;
	}
	
	
}
