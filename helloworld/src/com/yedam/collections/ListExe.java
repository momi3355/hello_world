package com.yedam.collections;

import java.util.ArrayList;
import java.util.List;

import com.yedam.bookapp.Book;
import com.yedam.bookapp.BookBuilder;

public class ListExe {
	public static void main(String[] args) {
		//배열을 활용해서 값을 추가할 경우.
		//새로운 배열을 선언 해서 기존의 값을 복사한 후 추가.
		int[] intAry = { 10, 20 };
		int[] intAry2 = new int[5];
		//add(30);
		for (int i = 0; i < intAry.length; i++) {
			intAry2[i] = intAry[i];
		}
		intAry2[2] = 30;
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(10); //추가
		list.add(20); //추가
		list.add(40); //추가
		Integer num1 = list.get(0); //조회
		list.remove(0);  //삭제
		list.set(0, 30); //수정
		list.add(1, 50); //삽입
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list "+(i+1)+". "+list.get(i));
		}
		
		List<Number> list2 = new ArrayList<Number>();
		list2.add(204.32);
		list2.add(200);
		list2.add(Byte.valueOf((byte)20));
		
		for (int i = 0; i < list2.size(); i++) {
			Class<? extends Number> result = list2.get(i).getClass();
			System.out.println(result.getSimpleName());
		}
		
		List<Book> list3 = new ArrayList<Book>();
		list3.add(new BookBuilder("금강산도 식후경")
				.setAuthor("강산")
				.setPublisher("금강산")
				.setPrice(12000)
				.build());
		
		for (Book book : list3) {
			System.out.println(book);
		}
	}
}
