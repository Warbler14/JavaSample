package com.lotus.jewel.sample.charecter;

public class CharacterBasic {

	public static void main(String[] args) {
		
		/*
		 	ampersand   &   &amp;amp;amp;amp;amp;
            apostrophe  '   &amp;amp;amp;#039;
            quotation   "   &amp;amp;amp;#034;
		 */
		
		Character ampersand = '&';
		Character apostrophe = '\'';
		Character quotation = '"';
		
		System.out.println(Integer.valueOf(ampersand));
		System.out.println(Integer.valueOf(apostrophe));
		System.out.println(Integer.valueOf(quotation));
		
	}
}
