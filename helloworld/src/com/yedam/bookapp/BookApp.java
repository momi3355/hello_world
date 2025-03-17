package com.yedam.bookapp;

import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {		
		Scanner scn = new Scanner(System.in);
		
		BookManager bookapp1 = BookManager.getInstance().setup(scn, "user", "user");
		BookManager bookapp2 = BookManager.getInstance().setup(scn, "user", "user");
		
//		bookapp1.addBook();
//		bookapp1.listBook();
//		
//		bookapp2.listBook();
		
		BookManager ba3 = BookManager.getInstance().setup("root", "root");
		ba3.run();
		
//		BookManager ba4 = BookManager.getInstance();
//		ba4.run();
		
		scn.close();
	}
}
