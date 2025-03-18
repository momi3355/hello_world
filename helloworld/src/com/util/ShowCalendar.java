package com.util;

import java.util.Calendar;

public class ShowCalendar {
	public static final String[] DAYS = {
		"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
	};
	public static final String[] DAYS_KOR = {
		"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"
	};
	private static final String RED  = "\u001B[31m" ;
	private static final String BLUE = "\u001B[34m" ;
	private static final String EXIT = "\u001B[0m" ;

	private Calendar cal;
	public ShowCalendar() {
		cal = Calendar.getInstance(); //now
		cal.set(Calendar.DATE, 1);
	}
	public ShowCalendar(Calendar cal) {
		this.cal = cal;
		this.cal.set(Calendar.DATE, 1);
	}
	public void setMonth(int month) {
		cal.set(Calendar.MONTH, month - 1);
	}
	public void setMonth(int year, int month) {
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
	}
	public void show() {
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int start = cal.get(Calendar.DAY_OF_WEEK);
		int end = cal.getActualMaximum(Calendar.DATE);
		System.out.println("\t  "+year+"년 "+month+"월");
		//표 머리글
		for (String day : DAYS)
			System.out.print(" "+day);
		System.out.println();
		int date = 0;
		for (int i = 1; date < end; i++) {
			if (start <= i) {
				String str = String.format("%2d", ++date);
				if (i % 7 == 0) {
					System.out.print(BLUE+"  "+str+EXIT);
				} else if (i % 7 == 1) {
					System.out.print(RED+"  "+str+EXIT);
				} else {
					System.out.print("  "+str);
				}
			} else {
				System.out.print("    ");
			}
			
			if (i % 7 == 0)
				System.out.println();
		}
		System.out.println();
	}
	
	public static String getDay(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		return DAYS_KOR[cal.get(Calendar.DAY_OF_WEEK) - 1]; //한글로 요일 출력
	}
	
	public static int getLastDate(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
}
