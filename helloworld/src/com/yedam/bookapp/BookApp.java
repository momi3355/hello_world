package com.yedam.bookapp;

import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {		
		Scanner scn = new Scanner(System.in);
		
		BookManager bookapp1 = BookManager.getInstance().setup(scn);
		BookManager bookapp2 = BookManager.getInstance().setup(scn);
		
//		bookapp1.addBook();
//		bookapp1.listBook();
//		
//		bookapp2.listBook();
		
		BookManager ba3 = BookManager.getInstance();
		ba3.login(new User("root", "관리자", "root"));
		ba3.run();
		
		scn.close();
	}
}
