package com.yedam.ref;

import com.util.Arrays;

public class ArrayExe1 {
	public static void main(String[] args) {
		Integer[] intArray = { 10, 20, 30 };
		Arrays.viewArray(intArray);
		
		intArray = new Integer[] { 40, 50, 60 }; //재햘당
		Arrays.viewArray(intArray);
		
		intArray = new Integer[10];
		intArray[3] = 30;
		intArray[9] = 90;
		
		intArray[1] = 100;
		int oddSum = 0;
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] == null) {
				intArray[i] = (int)(Math.random() * 100) + 1;
			}
			
			if (intArray[i] % 2 == 1) 
				oddSum += intArray[i];
		}
		Arrays.viewArray(intArray);
		System.out.println("홀수값의 합은 "+oddSum+"입니다.");
		
		Double[] lfArray = new Double[10];
		for (int i = 0; i < lfArray.length; i++)
			lfArray[i] = 1.1453 * (i + 1);
		Arrays.viewArray(lfArray);
		
		String[] strArray = new String[] {
				"Integer", "Double", "Long_Long", "Float"
		};
		Arrays.viewArray(strArray);
	}
}
