package com.yedam.inheritance;

public class UnivFriend extends Friend {
	private String univName;
	private String major;
	
	public UnivFriend() { 
		super();
	}
	public UnivFriend(String name, String tel, String univName, String major) {
		super(name, tel);
		this.univName = univName;
		this.major = major;
	}
	
	public String getUnivName() {
		return univName;
	}
	public String getMajor() {
		return major;
	}
	
	public void setUnivName(String univName) {
		this.univName = univName;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", "
				+ "대학이름은 "+getUnivName()+"이고, 학과는 "+getMajor()+"입니다.";
	}
}
