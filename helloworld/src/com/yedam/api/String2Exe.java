package com.yedam.api;

import java.io.UnsupportedEncodingException;

import com.util.StringEx;

public class String2Exe {
	void stringByte() {
		String str = "안녕하세요";
		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length: "+bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes1 -> String: "+str1);
		
		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println("bytes2.length: "+bytes2.length);
			String str2 = new String(bytes2);
			System.out.println("bytes2 -> String: "+str2);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String[] ssn = {  "9503061234567" 
						, "990603 2345678"
						, "030502-3456789" };
		
		for (String s : ssn) {
			System.out.println(s+" 해당 번호는 '"+StringEx.getGender(s)+"'입니다.");
		}
		
		String[] files = { "c:/temp/orange.jpg"
				, "d:/storage/test/grape.jpeg"
				, "d:/img/meon.png" };
		
		for (String fileName : files) {
			System.out.println("파일이름은: "+StringEx.getFileName(fileName));
			System.out.println("파일의 확장자는: "+StringEx.getExtName(fileName));
		}
	}
}
