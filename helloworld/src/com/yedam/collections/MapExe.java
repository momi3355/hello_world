package com.yedam.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.bookapp.Book;
import com.yedam.bookapp.BookBuilder;

public class MapExe {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(100, "홍길동");
		map.put(101, "김민수");
		map.put(102, "김혁수");
		map.put(102, "혁이"); //동일한 key값이 있으면 value가 교체 된다.
		
		//삭제.
		map.remove(101);
		
		Iterator<Entry<Integer, String>> entryiter = map.entrySet().iterator();
		while (entryiter.hasNext()) {
			Entry<Integer, String> entry = entryiter.next();
			System.out.println("key: "+entry.getKey()+", val: "+entry.getValue());
		}
		System.out.println();
		
		
		Map<String, Book> books = new HashMap<>();
		books.put("B001", new BookBuilder("이것이자바다")
								.setAuthor("신용권")
								.setPublisher("한빛출판사")
								.setPrice(20000).build());
		books.put("B002", new BookBuilder("자바스크립트")
								.setAuthor("김자바")
								.setPublisher("한빛출판사")
								.setPrice(25000).build());
		books.put("B003", new BookBuilder("HTML,CSS")
								.setAuthor("김자바")
								.setPublisher("한빛출판사")
								.setPrice(28000).build());
		// 검색.
		Book result = books.get("B001");
		
		//key set 반환
		Iterator<String> keyiter = books.keySet().iterator();
		while (keyiter.hasNext()) {
			String key = keyiter.next();
			System.out.println("key: "+key+", val: "+books.get(key));
		}
		System.out.println();
		
		//키: 값(entry)반환
		Set<Entry<String, Book>> entryset = books.entrySet();
		for (Entry<String, Book> entry : entryset) {
			System.out.println("key: "+entry.getKey()+", val: "+entry.getValue());
		}
		System.out.println();
		
		//value collection 반환
		Collection<Book> list = books.values();
		for (Book b : list) {
			System.out.println(b);
		}
		
		// { 'key', 'value' }
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); //자바객체 -> 문자열
		String json = gson.toJson(map);
		System.out.println(json); //객체 출력.
		
		json = gson.toJson(books);
		System.out.println(json);
		
		json = gson.toJson(result);
		System.out.println(json);
		
		Map<String, Integer[]> m = new HashMap<>();
		m.put("value", new Integer[] { 1, 40, 20, 60, 30 });
		json = gson.toJson(m);
		System.out.println(json);
	}
}
