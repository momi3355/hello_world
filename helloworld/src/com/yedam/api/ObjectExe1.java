package com.yedam.api;

class Member {
	String name;
	int age;
	public Member(String name) {
		this.name = name;
	}
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public int hashCode() {
		return (age << 8) + name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		//비교대상(매개값) Member타입.
		if (obj instanceof Member) {
			Member target = (Member)obj;
			if (target.name.equals(name)
					&& target.age == age)
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "이름: "+name+", 나이: "+age;
	}
}

public class ObjectExe1 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		System.out.println(obj1 == obj2);
		System.out.println(obj1.equals(obj2));
		
		Member m1 = new Member("임이지");
		m1.age = 20;
		Member m2 = new Member("임이지");
		m2.age = 20;
		System.out.println(m1.equals(m2));
		
	}
}
