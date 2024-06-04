package com.lotus.jewel.sample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaluratorTest {

	@Test
	@DisplayName("testing Sum")
	public void testSum() {
		Calcurator c = new Calcurator();
		double result = c.sum(10, 50);
		assertEquals(60, result);

		System.out.println("end!!");
	}
}