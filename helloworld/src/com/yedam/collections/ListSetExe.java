package com.yedam.collections;

import java.util.ArrayList;
import java.util.List;

public class ListSetExe {
	public static void main(String[] args) {
		Integer[] intAry = { 10, 20, 30 };
		System.out.print("intAry[ ");
		for (int i = 0; i < intAry.length; i++)
			System.out.print(intAry[i]+" ");
		System.out.println("]");
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(10);
		intList.add(20);
		intList.add(30);
		intList.add(50);
		System.out.print("intList[ ");
		for (int i = 0; i < intList.size(); i++)
			System.out.print(intList.get(i)+" ");
		System.out.println("]");
	}
}
