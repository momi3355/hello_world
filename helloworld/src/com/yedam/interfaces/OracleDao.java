package com.yedam.interfaces;

/**
 * 1차 프로젝트.
 * 등록(add), 수정(modify), 삭제(delete)
 * Interface Dao를 사용하면 통일이 된다.
 */
public class OracleDao implements Dao {
	@Override
	public void insert() {
		System.out.println("oracle 용 등록");
	}
	
	@Override
	public void update() {
		System.out.println("oracle 용 수정");
	}

	@Override
	public void delete() {
		System.out.println("oracle 용 삭제");
	}
}
