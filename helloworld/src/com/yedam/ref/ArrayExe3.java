package com.yedam.ref;

import com.util.ShowCalendar;

public class ArrayExe3 {
	public static void main(String[] args) {
		ShowCalendar sc1 = new ShowCalendar();
		sc1.setMonth(2026, 5);
		sc1.show();
		ShowCalendar sc2 = new ShowCalendar();
		sc2.setMonth(2020, 2);
		sc2.show();
	}
}
