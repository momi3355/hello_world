package com.yedam.variable;

import java.util.Scanner;

public class VarExe6 {
	public static void test() {
		//임의의 정수 1 ~ 50 임의의값.
//		for (int i = 0; i < 10; i++) {
//			int r_num = (int)(Math.random() * 50) + 1;
//			System.out.println(r_num);
//		}
		//학생의 점수(30~100)사이의 점수
		//정수타입의 배열 5개 저장.
		//홀수의 값을 출력.
		
		int[] scores = new int[5];
		System.out.print("scores[");
		for (int i = 0; i < scores.length; i++) {
			scores[i] = (int)(Math.random() * 71) + 30;
			System.out.print(" "+scores[i]+" ");
		}
		System.out.println("]");
		
		System.out.print("홀수의 값은 :");
		for (int i = 0; i < scores.length; i++) {
//			if (scores[i] == 100) {
//				System.out.println("index = "+i);
//			}
			if (scores[i] % 2 == 1) {
				System.out.print(" "+scores[i]);
			}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//test();
		Member m1 = new Member(); //인스턴스 생성.
		m1.setName("이창현");
		
		Member m2 = new Member(); //인스턴스 생성.
		m2.setName("최민수");
		
		Member m3 = new Member(); //인스턴스 생성.
		m3.setName("김병수");
		
		Member m4 = new Member(); //인스턴스 생성.
		m4.setName("박인만");
		
		//배열.
		Member[] members = new Member[] {
				m1, m2, m3, m4
		};
		
		//70 ~ 100사이의 임의값으로 점수지정.
		int index = -1;
		int max = 0;
		for (int i = 0; i < members.length; i++) {
			Member element = members[i];
			element.setScore((int)(Math.random() * 30) + 70);
			System.out.println(element.getName()+":"+element.getScore());
			if (max == 0 || max < element.getScore()) {
				max = element.getScore();
				index = i;
			}
		}
		//점수가 가장 높은 사람의 이름 출력.
		System.out.println("점수가 가장높은 사람 : "+members[index].getName());
		
		// 조회하고 싶은 이름 입력 -> 점수 출력.
		System.out.print("조회할 이름 입력.>_");
		String searchName = scn.nextLine();
		for (int i = 0; i < members.length; i++) {
			Member element = members[i];
			// '==' 는 포인터 비교 연산자이기 때문에 같은 값이라도 포인터가 다르면 'false'가 나온다.
			//그래서 값만 비교하는 equals()메소드를 사용해야한다.
			if (element.getName().equals(searchName) ) {
				System.out.println(element.getName()+":"+element.getScore());
			}
		}
		scn.close();
	} //end of main();
}
