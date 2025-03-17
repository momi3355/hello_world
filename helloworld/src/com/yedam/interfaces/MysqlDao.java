package com.yedam.interfaces;

/**
 * 1차 프로젝트.
 * 등록(insert), 수정(modify), 삭제(remove)
 * Interface Dao를 사용하면 통일이 된다.
 */
public class MysqlDao implements Dao {
	@Override
	public void insert() {
		System.out.println("mysql용 등록");
	}
	
	@Override
	public void update() {
		System.out.println("mysql용 수정");
	}

	@Override
	public void delete() {
		System.out.println("mysql용 삭제");
	}
}
