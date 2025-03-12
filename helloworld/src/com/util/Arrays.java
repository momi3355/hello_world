package com.util;

public class Arrays {
	private static void swap(Object[] obj, int a_idx, int b_idx) {
		Object temp = obj[a_idx];
		obj[a_idx] = obj[b_idx];
		obj[b_idx] = temp;
	}
	
	public static void viewArray(Object[] obj) {
		String name = obj.getClass().getSimpleName().replace("[]", "");
		System.out.print(name+" [");
		for (int i = 0; i < obj.length; i++)
			System.out.print(" "+obj[i]);
		System.out.println(" ]");
	}
	
	public static void sort(Object[] obj) {
		//숫자거나 문자거나.
		if (obj[0] instanceof Number) {
			for (int i = 0; i < obj.length - 1; i++) {
				int min_idx = i;
				Number min = (Number)obj[min_idx];
				for (int j = i + 1; j < obj.length; j++) {
					if (min.floatValue() > ((Number)obj[j]).floatValue()) {
						min = (Number)obj[j];
						min_idx = j;
					}
				}
				swap(obj, min_idx, i);
			}
		} else if (obj[0] instanceof String) {
			for (int i = 0; i < obj.length - 1; i++) {
				int min_idx = i;
				String min = (String)obj[min_idx];
				for (int j = i + 1; j < obj.length; j++) {
					if (min.compareTo((String) obj[j]) > 0) {
						min = (String)obj[j];
						min_idx = j;
					}
				}
				swap(obj, min_idx, i);
			}
		} else {
			System.out.println("정렬할 수 없는 클래스 입니다.");
			return;
		}
	}
}
