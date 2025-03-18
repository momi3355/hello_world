package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {

	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today);
		
		//날자 출력 포맷.
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		System.out.println(date.format(today));
		
		try {
			//문자열로 날자 포맷에 맞게 변환한다. String to Date
			Date tday = date.parse("2000-01-01 오전 10:00:00");
			System.out.println(tday);
		} catch (ParseException e) {
			System.out.println("날자로 변환에 실패했습니다.");
		}
	}

}
