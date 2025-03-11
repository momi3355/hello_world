package com.yedam.variable;

import java.util.Scanner;

public class VarExe4 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] scores = new int[3]; // { 0, 0, 0 };
		
		long sum = 0;
		double avg = 0.0d;
		for (int i = 0; i < scores.length; i++) {
			//점수를 입력하세요.
			System.out.print("점수를 입력하세요>_");
			//값 입력.
			scores[i] = scn.nextInt();
			sum += scores[i];
		}
		avg = sum / (double)scores.length;
		
		//입력값의 합을 콘솔에 출력.
		//ex) "합은 240입니다."
		System.out.println("합은"+sum+", 평균은"+String.format("%.2f", avg)+"입니다.");
		
		scn.close();
	}
}
