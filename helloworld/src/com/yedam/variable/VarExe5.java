package com.yedam.variable;

import java.util.Scanner;

//예금과 출금을 할 수 있는 은행 프로그램.
public class VarExe5 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int day_limit = 0;
		int balance = 0; //예금액을 저장하는 변수.
		//예금의 한도 10만원.
		
		while (run) {
			System.out.println("1. 예금  2. 출금  3. 잔고 확인  4. 종료");
			System.out.print(">_");
			int menu = scn.nextInt();
			
			switch (menu) {
			case 1:
				System.out.print("얼마를 입금하시겠습니까>>_");
				int in = scn.nextInt();
				day_limit += in;
				if (day_limit > 100000) {
					System.out.println("하루 입금한도가 초과하셨습니다.");
					day_limit -= in;
				} else {
					balance += in;//balance = balance + in;
				}
				break;
			case 2:
				System.out.print("얼마를 출금하시겠습니까>>_");
				int out = scn.nextInt();
				if (balance - out < 0) {
					System.out.println("돈이 부족합니다.");
				} else {
					balance -= out;
				}
				break;
			case 3:
				System.out.println("현재 잔고는 "+balance+"입니다.");
				break;
			case 4: run = false; break;
			default:
				System.out.println("숫자를 잘못 입력하셨습니다.");
			}
		}
		
		System.out.println("end of prog.");
		scn.close();
	}
}
