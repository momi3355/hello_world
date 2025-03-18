package com.yedam.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yedam.variable.Member;

public class SetExe {

	public static void main(String[] args) {
		//set은 'hash code' 'equals'를 비교해서 중복을 확인한다.
		Set<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("World");
		set.add(new String("Hello")); //중복 안됨
		
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String item = iter.next();
			System.out.println(item);
		}
		//이런식으로 적어도 된다.
//		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
//			String string = iterator.next();
//			System.out.println(string);
//		}
		
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 80));
		members.add(new Member("김민규", 85));
		members.add(new Member("홍길동", 80));
		
		//ForEach는 'Iterator'가 구현되어 있어야지 사용이 가능하다.
		for (Member mem : members) {
			System.out.print(mem.toString());
		}
		
//		Iterator<Member> mem_iter = members.iterator();
//		while (mem_iter.hasNext()) {
//			Member mem = mem_iter.next();
//			System.out.print(mem.toString());
//		}
		
		//int -> Integer
		int[] intAry = { 10, 20, 30, 40, 20, 10 };
		//int배열에서 중복된 값을 제거한 결과 List 추가.
		//List를 출력.
		//int[] to Set<Integer> to List<Integer>;
		List<Integer> listIntAry = new ArrayList<>(
				Arrays.stream(intAry) //기본자료형의 배열
                	  .boxed() //박싱(int to Integer)
                	  .collect(Collectors.toSet())); //Array to Set
		//최종적으로 중복값이 없는 'list'가 만들어 진다.
		
		//자바스크립트처럼 forEach()메소드가 있다.
		listIntAry.forEach(n -> System.out.print(n+" "));
	}

}
