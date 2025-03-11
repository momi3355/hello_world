package com.yedam.ref;

import com.util.Arrays;
import com.yedam.variable.Member;

public class ArrayExe2 {
	public static void main(String[] args) {
		String[] strArray = { "Hello", "World", "20", "23.4" };
		// 확장 for.
		for (String str : strArray)
			System.out.print(" "+str);
		System.out.println();
		// 크기지정.
		strArray = new String[10]; // { null, null, ... }
		strArray[0] = "Nice";
		strArray[4] = "Good";
		strArray[7] = "Google";
		Arrays.viewArray(strArray);
		
		// object는 null로 초기화 된다.
		Member[] memArray = new Member[10];
		memArray[0] = new Member("이창현", 45);
		memArray[1] = new Member("김경남", 50);
		memArray[1].setScore(90);
		memArray[2] = new Member("강주조", 60);
		memArray[3] = new Member("박민동", 85);
		memArray[3].setScore(95);
		memArray[4] = new Member();
		memArray[4].setMember("정수재", 80);
		
		System.out.println();
		memArray[1].showInfo();
		memArray[3].showInfo();
		System.out.println();
		
		System.out.println("3. 이름: "+memArray[3].getName()
				+ ", 점수: "+memArray[3].getScore()+"\n");
		
		Arrays.viewArray(memArray);
	}
}
