package com.yedam.classes;

public class MethodExe1 {
	//리턴 타입 메소드 이름(매개변수...) {
	//   실행 블록
	//}
	
	void printString() {
		printString(1, "&");
	}
	void printString(int count, String c) {
		String str = ""+c;
		for (int i = 0; i < count; i ++) {
			str += c;
		}
		System.out.println(str);
	}
	
	Object sum(Object a, Object b) {
		if (a instanceof Number && a instanceof Number) {
			return ((Number)a).doubleValue() + ((Number)b).doubleValue();
		} else {
			return a.toString().concat(b.toString());
		}
	}
	
	int sum(int[] intArray) {
		int result = 0;
		for (int i = 0; i < intArray.length; i++) {
			result += intArray[i];
		}
		return result;
	}
	
	double sum(double[] doubleArray) {
		double result = 0;
		for (int i = 0; i < doubleArray.length; i++) {
			result += doubleArray[i];
		}
		return result;
	}
	
	int test(int... dd) {
		int result = 0;
		for (int i = 0; i < dd.length; i++) {
			result += dd[i];
		}
		return result;
	}
}
