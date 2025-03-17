package com.yedam.inheritance;

public abstract class Animal {
	abstract void sound(); //자식클래스에 규칙을 지정.
	void eat() {
		System.out.println("먹는다.");
	}
}
