package com.lotus.jewel.sample;

import org.apache.commons.lang3.time.StopWatch;

public class SlowProgram {

	private StopWatch stopWatch;
	
//	@BeforeAll
	public void setUp() {
		stopWatch = new StopWatch("slowProgram");
	}
	
//	@Test
	public void testSlowProgram() {
		stopWatch.start();
		
		Long sum = 0L;
		for(long i = 0 ; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		
		stopWatch.stop();
		
		System.out.println(sum);
		System.out.println(stopWatch.getTime() + " ms");
	}
	
}
