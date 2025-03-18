package com.yedam.variable;

import java.util.Objects;

//접근제한
// public    아무나
// default   패키지안에서
// private   내부에만
// protected 자식도 사용가능
public class Member {
	//클래스: 필드(변수)
	private String name;
	private int score;
	
	//클래스: 메소드(기능)
	public Member() { /* null */ }
	public Member(String name, int score) {
		setMember(name, score);
	}
	
	public void setMember(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		if (score < 0 || score > 100) {
			System.out.println("점수는 0보다 큰값입니다.");
			return;
		}
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	
	public void showInfo() {
		System.out.print(this);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", score=" + score + "]\n";
	}
}
