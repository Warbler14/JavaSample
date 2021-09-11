package com.lotus.jewel.sample;

import org.junit.Test;
import static org.junit.Assert.*;

public class GoodThingsTest {

	@Test
	public void testGoodThings() {
		
		GoodThings goodThings = new GoodThings();
		
		assertEquals(2, goodThings.getGoodThings().length);
		
	}
}
