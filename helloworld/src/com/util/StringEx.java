package com.util;

import java.util.Arrays;
import java.util.List;

public class StringEx {
	public static String getGender(String ssn) {
		String temp = ssn.replaceAll("[^0-9]|\\s", ""); //숫자이외 or 공백문자
		if (temp.length() != 13) return null;
		return (temp.charAt(temp.length()-7) % 2 == 1) ? "남" : "여";
	}

	public static String getFileName(String file) {
//		List<String> path = Arrays.asList(file.split("/"));
//		String fileName = path.getLast();
//		return fileName.substring(0, fileName.indexOf('.'));
		return file.substring(file.lastIndexOf('/')+1, file.lastIndexOf('.'));
	}

	public static String getExtName(String file) {
		return file.substring(file.lastIndexOf('.')+1);
	}
}
