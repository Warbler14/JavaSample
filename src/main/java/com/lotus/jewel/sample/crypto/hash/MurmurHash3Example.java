package com.lotus.jewel.sample.crypto.hash;


import org.apache.commons.codec.digest.MurmurHash3;

public class MurmurHash3Example {
	public static void main(String[] args) {
		String input = "Hello, MurmurHash3!";

		// MurmurHash3 32비트 해시 생성
		int hash32 = MurmurHash3.hash32(input.getBytes());
		System.out.println("MurmurHash3 32-bit hash: " + hash32);

		// MurmurHash3 128비트 해시 생성
		long[] hash128 = MurmurHash3.hash128(input.getBytes());

//		byte[] hash128 = MurmurHash3.hash128(input.getBytes());
		System.out.println("MurmurHash3 128-bit hash: ");
		for (long b : hash128) {
			System.out.format("%02x", b);  // 128비트 해시를 16진수로 출력
		}
		System.out.println();
	}
}
