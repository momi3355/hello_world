package com.yedam.exceptions;

import java.util.Scanner;

public class NumberFormatExe {
	static void exceptMethod() throws NumberFormatException {
		Scanner scn = new Scanner(System.in);
		int no = 0;
		System.out.print("정수를 입력하세요.");
		String strNo = scn.nextLine();
		no = Integer.parseInt(strNo);
		System.out.println(no);
		scn.close();
	}
	
	public static void main(String[] args) {
		try {
			exceptMethod();
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력하지 않았습니다.");
		} finally {
			System.out.println("정상실행 or 예외발생 반드시 실행코드");
			//대체적으로 close()를 사용.(입력, DB)
		}
		System.out.println("end of prog.");
	}
}
