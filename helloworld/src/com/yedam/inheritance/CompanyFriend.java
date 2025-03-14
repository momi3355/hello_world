package com.yedam.inheritance;

public class CompanyFriend extends Friend {
	private String company;
	private String dept;
	
	public CompanyFriend() {
		super();
	}
	public CompanyFriend(String name, String tel, String company, String dept) {
		super(name, tel);
		this.company = company;
		this.dept = dept;
	}
	public String getCompany() {
		return company;
	}
	public String getDept() {
		return dept;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return super.toString()+", "
				+ "회사이름은 "+getCompany()+"이고, 부서는 "+getDept()+"입니다.";
	}
}
