package com.yedam.variable;

//데이터 유형(dataType)
class Student {
	String name;
	int score;
	float height;
	
	@Override
	public String toString() {
		return "이름: "+name+", 점수: "+score+", 키: "+height;
	}
}

public class VarExe2 {
	public static void main(String[] args) {
		String name = "홍길동";
		int score = 100;
		
		Student stu1 = new Student(); //인스턴스 생성.
		stu1.name = "김민수";
		stu1.score = 90;
		stu1.height = 178.9f;
		
		System.out.println(stu1.toString());
		
		Student stu2 = new Student();
		stu2.name = "최우석";
		stu2.score = 92;
		stu2.height = 168.9f;
		
		System.out.println(stu2.toString());
		
		int[] scores = { 89, 77, 60, score };
		int sum = 0;
		System.out.print("합계는 : ");
		for (int i = 0; i < scores.length; i++) {
			System.out.print((i == scores.length-1) ? scores[i]+" = " : scores[i]+"+");
			sum += scores[i];
		}
		System.out.println(sum);
		
		String[] names = { "박승호", "김주승", name };
		for (int i = 0; i < names.length; i++) {
			System.out.println("이름 =>" + names[i]);
		}
		
		Student[] students = { stu1, stu2 };
		for (int i = 0; i < students.length; i++) {
			Student element = students[i];
//			System.out.println("이름: "+element.name
//					+ ", 점수: "+element.score
//					+ ", 키: "+element.height);
			System.out.println(element);
		}
	}
}
