package com.yedam.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.yedam.variable.Member;

public class MapExe2 {
	
	public static void main(String[] args) {
		Map<Member, Double> map = new HashMap<>();
		map.put(new Member("홍길동", 80), 174.8d);
		map.put(new Member("김길동", 82), 170.4d);
		map.put(new Member("박동길", 78), 167.8d);
		
		map.remove(new Member("박동길", 78));
		long start, end;
		start = System.nanoTime();
		Iterator<Entry<Member, Double>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Member, Double> entry = iter.next();
			System.out.println("key: "+entry.getKey()+", val: "+entry.getValue());
		}
		end = System.nanoTime();
		System.out.println((end-start)/1000000.0+"ms");
		
		//확장 for 가 빠르다. (80 - 100배 차이)
		start = System.nanoTime();
		Set<Entry<Member, Double>> set = map.entrySet();
		for (Entry<Member, Double> entry : set) {
			System.out.println("key: "+entry.getKey()+", val: "+entry.getValue());
		}
		end = System.nanoTime();
		System.out.println((end-start)/1000000.0+"ms");
	}
}
