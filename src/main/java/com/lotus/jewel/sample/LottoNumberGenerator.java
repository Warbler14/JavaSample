package com.lotus.jewel.sample;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

	public List<Object> generate(final int money) {
		if(!isValidMoney(money)) {
			throw new RuntimeException("올바른 금액이 아닙니다.");
		}
		return generate();
	}
	
	private boolean isValidMoney(final int money) {
		return money == 1000;
	}
	
	private List<Object> generate() {
		return new Random()
				.ints(1, 45 + 1)
				.distinct()
				.limit(6)
				.boxed()
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
		final int price = 1000;
		
		final List<Object> lottoNumbers = lottoNumberGenerator.generate(price);
		for (Object object : lottoNumbers) {
			System.out.println(  String.valueOf(object) );
		}
	}
}
