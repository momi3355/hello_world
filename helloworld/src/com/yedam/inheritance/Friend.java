package com.yedam.inheritance;

public class Friend {
	private String name;
	private String tel;
	
	public Friend() { /* null */}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	
	//final 메소드면 자식클래스가 재정의가 불가능 하다.
	public final void setName(String name) {
		this.name = name;
	}
	public final void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "이름은 " + getName() + ", 전화번호는 " + getTel();
	}
}
