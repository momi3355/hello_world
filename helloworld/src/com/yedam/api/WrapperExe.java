package com.yedam.api;

import java.util.ArrayList;
import java.util.List;

public class WrapperExe {
	public static void main(String[] args) {
		int[] intAry = { 10, 20 };
		List<Integer> list = new ArrayList<>();
		
		//int -> Integer 박싱, Integer -> int 언박싱.
		list.add(10); //list.add(Integer.valueOf(10));
		
		int num1 = 2000;
		Integer num2 = 2000; //자동 박싱
		Integer num3 = Integer.valueOf(2000); //박싱
		//num2과 num3는 다른 개체이다.
		
		//int Integer비교는 가능
		System.out.println(num1 == num2); //true
		// [-128 - 127]범위를 초과하면 'false'가 나온다.
		System.out.println(num2 == num3); //false
		
	}
}
