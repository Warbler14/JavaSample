package com.lotus.jewel.sample.collection.list;

import java.util.Stack;

public class StackBasic {
	
	public StackBasic() {
		super();
		System.out.println("----- Stack Basic -----");
	}

	public void test01 () {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.pop();
		
		if(! stack.contains(4)) {
			stack.push(4);
		}
		
		if(! stack.contains(5)) {
			stack.add(5);
		}
		
		System.out.println("size : " + stack.size());
		
		Integer peak1 = stack.peek();
		System.out.println("peak1 : " + peak1);
		
	}
}
