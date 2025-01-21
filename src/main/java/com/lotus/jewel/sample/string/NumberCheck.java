package com.lotus.jewel.sample.string;

public class NumberCheck {


	public static void main(String[] args) {

		test(null);
		test(" ");
		test("100");
		test("0.1");
		test("0.1");

	}

	public static void test(String str) {
		boolean result = isNumberic(str);

		System.out.print(str + " : ");
		if (!result) {
			System.out.println(Fonts.FONT_RED + result + Fonts.RESET);
		} else {
			System.out.println(result);
		}
	}

	public static boolean isNumberic(String string) {
		try {
			Float.parseFloat(string);
			return true;
		} catch (NumberFormatException | NullPointerException e) {
			return false;
		}
	}
}
