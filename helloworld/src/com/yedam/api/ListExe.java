package com.yedam.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListExe {
	public static void main(String[] args) {
		//배열 : int[], String[] => intAry[0];
		//List컬렉션 : List<Integer>, List<String>, List<Member>
		// intList.get(0);
		List<Integer> intList = new ArrayList<>();
		intList.add(100);
		intList.add(150);
		intList.add(60);
		intList.add(100);
		
		for (int i = 0; i < intList.size(); i++) {
			System.out.println((i + 1)+". "+intList.get(i));
		}
//		for (int num : intList) {
//			System.out.println(num);
//		}
		
		//Set컬렉션.
		Set<Integer> intSet = new HashSet<>();
		intSet.add(100);
		intSet.add(150);
		intSet.add(60);
		intSet.add(100);
		
		for (int num : intSet) {
			System.out.println(num);
		}
		
		//Set<Member>
		Set<Member> members = new HashSet<>();
		members.add(new Member("홍길동", 20));
		members.add(new Member("박태욱", 21));
		members.add(new Member("최선욱", 22));
		members.add(new Member("최선욱", 22));
		members.add(new Member("이창현", 32));
		//Set의 중복데이터 확인 절차 hashCode를 먼저 확인 후에
		// equals를 확인해서 둘다 true일때 중복인지 확인 한다.
		
		for (Member m : members) {
			System.out.println(m);
		}
	}
}
