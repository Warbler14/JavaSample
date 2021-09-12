package com.lotus.jewel.sample;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Application {

	public static void main(String argsp[]) {
		
		int number = 0;
		System.out.println(number++);
		System.out.println(number++);
		System.out.println(number++);
		System.out.println(number++);
		System.out.println(number++);
		System.out.println(number++);
		
		for(int idx = 0 ; idx < number ; idx++ ) {
			if(idx%2 == 0) {
				System.out.println(idx + " is even" );
			} else {
				System.out.println(idx + " is odd" );
			}
		}
		
		List<Date> dateList = new ArrayList<Date>();
		for(int idx = 0 ; idx < 10000 ; idx++) {
			Calendar cal = Calendar.getInstance();
			
			dateList.add(cal.getTime());
		}
		
		System.out.println("end of line");
	}
}
