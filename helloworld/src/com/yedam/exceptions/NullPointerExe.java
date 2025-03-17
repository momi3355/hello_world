package com.yedam.exceptions;

public class NullPointerExe {
	public static void main(String[] args) {
		String str = "Hello";
		int[] intArray = { 10, 20 };
		//예외처리.
		try {
			System.out.println(str.toString());
			intArray[2] = 30;
		} catch (NullPointerException e) {
			System.out.println("지금 NULL를 참조하고 있습니다.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("지금 배열인덱스의 범위가 벗어났습니다");
		} finally {
			System.out.println("end of prog.");
		}
	}
}
