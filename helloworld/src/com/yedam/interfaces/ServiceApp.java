package com.yedam.interfaces;

/**
 * 실행 클래스.
 */
public class ServiceApp {
	public static void main(String[] args) {
		Dao dao = new MysqlDao();
		//Dao dao = new OracleDao(); 
		//인터페이스 타입변수 = 구현객체;
		//등록
		dao.insert();
		//수정
		dao.update();
		//삭제
		dao.delete();
	}
}
