package com.lotus.jewel.sample;

import org.junit.Test;

import com.lotus.jewel.sample.mind.GoodThings;

import static org.junit.Assert.*;

public class GoodThingsTest {

	@Test
	public void testGoodThings() {
		
		GoodThings goodThings = new GoodThings();
		
		assertEquals(2, goodThings.getGoodThings().length);
		
	}
}
