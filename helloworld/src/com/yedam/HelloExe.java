package com.yedam;

import java.util.Arrays;

//struct info {
//    char** name;
//    char** tel;
//    int age
//} Info;
class Info {
	private String name;
	private String tel;
	private int age;
	
	public Info(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}
	
	public String getName() { return name; }
	public String getTel()  { return tel ; }
	public int    getAge()  { return age ; }

	@Override
	public String toString() {
		return "Info [name=" + name + ", tel=" + tel + ", age=" + age + "]";
	}
}

public class HelloExe {
	
	//이것은 HelloExe의 메인
	public static void main(String[] args) {
		int num = 32000;
		int[] nums = new int[] { 34, 32, 88, 23 };
		
		String str = String.valueOf(32);
		int str_int = Integer.parseInt(str);
		String[] strs = new String[] { "Hello", "Nice", "Good" };
		
		int[] intArray = new int[5];
		for (int i = 0; i < intArray.length; i++)
			intArray[i] = (int)(Math.random() * 41) + 60;
		System.out.println(Arrays.toString(intArray));
		
		//이름, 연락처, 나이.
		Info info = new Info("홍길동", "010-1234-1234", 21);
		System.out.println(info);
		
		Info[] infos = new Info[3];
		infos[0] = new Info("홍길동", "010-1234-5678", 20);
		infos[1] = new Info("김민석", "010-2222-2222", 22);
		infos[2] = new Info("최문식", "010-3333-3333", 23);
		
		int idx = 0;
		int mostAge = infos[0].getAge();
		for (int i = 1; i < infos.length; i++) {
			if (mostAge < infos[i].getAge()) {
				mostAge = infos[i].getAge();
				idx = i;
			}
		}
		System.out.println("나이가 가장 많은 사람은 "
				+ infos[idx].getAge()+"살 "+infos[idx].getName()+"입니다.");
	}
	
}
