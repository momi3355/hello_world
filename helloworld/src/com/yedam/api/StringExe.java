package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str1 = "Hello, world";
		String str2 = new String("Hello, world");
		
		byte[] strByte = str1.getBytes();
		for (int i = 0; i < strByte.length; i++)
			System.out.print(" "+strByte[i]);
		System.out.println();
		
		byte[] byteStr = { 72, 101, 108, 108, 111, 44, 32, 119, 111, 114, 108, 100 };
		String msg = new String(byteStr, 7, 5); // 인덱스 7에서 5개의 문자열
		System.out.println(msg);
		
		char result = msg.charAt(0);
		System.out.println((int)result);
		if (result == 'w') {
			System.out.println("문자 비교");
		}
		
		int idx = msg.indexOf("ld");
		if (idx != -1) {
			System.out.println("문자열이 존재함");
		}
		
		String[] names = { "홍길동", "홍길승", "김길규" };
		int cnt1 = 0;
		int cnt2 = 0;
		for (String name : names) {
			if (name.contains("길")) //name.indexOf("길") >= 0
				cnt1++;
			if (name.indexOf("홍") == 0)
				cnt2++;
		}
		System.out.println("'길'을 포함하는 이름의 갯수: "+cnt1+"명");
		System.out.println("성씨가 '홍'인 이름의 갯수: "+cnt2+"명");
		
		System.out.println(str1.substring(3, 7)); // 인덱스 3에서 (7-1)까지
		if (str1 != str2) System.out.println("문자열이 다름(생성자)");
		str2 = "Hello, world";
		if (str1 == str2) System.out.println("문자열이 같음(문자 리터널)");
	}
}
