package com.yedam.variable;

public class VarExe8 {
	public static void main(String[] args) {
		/* 정수
		 * byte  = 1byte
		 * char  = 2byte
		 * short = 2byte
		 * int   = 4byte
		 * long  = 8byte
		 * 
		 * 실수
		 * float  = 4byte
		 * double = 8byte
		 * 
		 * 논리
		 * boolean = 1bit
		 * */
		int n1 = 10;
		byte b1 = 120;
		byte result = (byte)(b1 + 130);
		System.out.println("더한결과: "+result);
		System.out.println("더한결과: "+(Integer.MAX_VALUE+1));
		//byte -> int
		n1 = b1;
		System.out.println(n1);
		n1 = 200;
		b1 = (byte) n1;
		System.out.println(b1);
		
//		for (int i = 1; i < 15; i++) {
//			System.out.println(b1++);
//		}
	}
}
