package com.yedam.variable;

//관례: 클래스의 이름은 대문자로 시작.
public class VarExe1 {
	//연산은 두 변수의 유형(dataType)이 동일.
	public static void main(String[] args) {
		int num1 = 70, num2 = 80;
		num1 = 71;
		int sum = num1 + num2;
		
		System.out.println("두 점수의 합은 "+sum+"입니다.");
		
		float avg = sum / 2.0f;
		System.out.println("두 점수의 평균은 "+avg+"입니다.");
	}
}
