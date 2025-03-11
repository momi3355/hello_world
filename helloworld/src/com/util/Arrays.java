package com.util;

public class Arrays {
	public static void viewArray(Object[] obj) {
		String name = obj.getClass().getSimpleName().replace("[]", "");
		System.out.print(name+" [");
		for (int i = 0; i < obj.length; i++)
			System.out.print(" "+obj[i]);
		System.out.println(" ]");
	}
}
