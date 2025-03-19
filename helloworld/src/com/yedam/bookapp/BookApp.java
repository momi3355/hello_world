package com.yedam.bookapp;

import java.util.List;
import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {		
		Scanner scn = new Scanner(System.in);
		
		
		BookJdbc dao = new BookJdbc();
		
		Book book = new BookBuilder("이클립트")
				.setAuthor("신용")
			    .setPublisher("어둠출판사")
			    .setPrice(23000).build();
//		if (dao.insert(book)) {
//			System.out.println("등록성공");
//		} else {
//			System.out.println("등록실패");
//		}
		
		Book book2 = new BookBuilder("자바스크립트 기초")
				.setAuthor("신용권")
				.setPrice(25000).build();
//		if (dao.update("5", book2)) {
//			System.out.println("수정성공");
//		} else {
//			System.out.println("수정실패");
//		}
		
//		if (dao.delete("4")) {
//			System.out.println("삭제성공");
//		} else {
//			System.out.println("삭제실패");
//		}
		
//		List<Book> list = dao.list();
//		for (Book b : list) {
//			System.out.println(b.showList());
//		}
		
		BookManager_backup bookapp1 = BookManager_backup.getInstance().setup(scn, "user", "user");
		BookManager_backup bookapp2 = BookManager_backup.getInstance().setup(scn, "user", "user");
		
//		bookapp1.addBook();
//		bookapp1.listBook();
//		
//		bookapp2.listBook();
		
		BookManager_backup ba3 = BookManager_backup.getInstance().setup("root", "root");
		//ba3.run();
		
//		BookManager ba4 = BookManager.getInstance();
//		ba4.run();
		
		BookManager bookapp = BookManager.getInstance().setup("user", "user");
		bookapp.run();
		
		scn.close();
	}
}
