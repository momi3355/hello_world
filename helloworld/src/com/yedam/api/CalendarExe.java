package com.yedam.api;

import java.util.Calendar;

import com.util.ShowCalendar;

public class CalendarExe {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2024); //2024년
		cal.set(Calendar.MONTH, 1); //2월
		cal.set(Calendar.DATE, 10); //10일
		cal.set(2023, 2, 5); //2023년 3월 5일
		
		//'Calendar.DAY_OF_MONTH' 랑 'Calendar.DATE' 동일 하다.
		System.out.print(cal.get(Calendar.YEAR)+"년 ");
		System.out.print(cal.get(Calendar.MONTH)+1+"월 ");
		System.out.print(cal.get(Calendar.DAY_OF_MONTH)+"일 "); //cal.get(Calendar.DATE);
		System.out.println(ShowCalendar.DAYS_KOR[cal.get(Calendar.DAY_OF_WEEK) - 1]);
		System.out.println(cal.get(Calendar.MONTH)+1+"월달의 마지막날 "
				+ cal.getActualMaximum(Calendar.DATE)+"일");
		
		int year = 2020;
		int month = 2;
		// 년, 월 입력 => 그 달의 1일의 요일 변환, 말일을 변환
		String dayWeek = ShowCalendar.getDay(year, month); //7월달의 1일의 요일
		System.out.println(year+"년 "+month+"달의 첫번째 요일은 "+dayWeek+"입니다.");
		int lastDay = ShowCalendar.getLastDate(year, month); //7월달의 마지막날
		System.out.println(year+"년 "+month+"달의 마지막날은 "+lastDay+"일 입니다.\n");
		
		ShowCalendar sc = new ShowCalendar();
		sc.setMonth(year, month);
		sc.show();
	}
}
