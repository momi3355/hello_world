package com.yedam.calendar;

import java.text.SimpleDateFormat;
import java.util.Locale;

public interface CalendarDate {
	SimpleDateFormat defaultDate = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH);
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
