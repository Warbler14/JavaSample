package com.lotus.jewel.sample;

import org.junit.Test;
import static org.junit.Assert.*;

public class CaluratorTest {

	@Test
	public void testSum() {
		Calcurator c = new Calcurator();
		double result = c.sum(10, 50);
		assertEquals(60, result, 1);
	}
}