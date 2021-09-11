package com.lotus.jewel.sample;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

public class LottoNumberGeneratorTest {

	//@DisplayName("lotto number size test")
	@Test
	public void lottoNumberSizeTest() {
		
		final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
		final int price = 1000;
		
		final List<Object> lottoNumbers = lottoNumberGenerator.generate(price);
		
		assertEquals(6, lottoNumbers.size(), 1);
		assertThat(lottoNumbers.size(), is(6));
		//assertThat(lottoNumbers.stream().allMatch(v->v>=1 && v<=45)).isTrue();
	}
}
