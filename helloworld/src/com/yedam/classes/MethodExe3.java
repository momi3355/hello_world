package com.yedam.classes;

public class MethodExe3 {
	
	String gugudan(int num) {
		return gugudan(num, num);
	}
	String gugudan(int num, int toNum) {
		String str = "";
		for (int i = num; i <= toNum; i++) {
			str += "==== "+i+"단 ====\n";
			for (int j = 1; j <= 9; j++) {
				str += i+" x "+j+" = "+(i*j)+"\n";
			}
		}
		return str;
	}
	
	void printStar(int cnt, String str) {
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(str);
			}
			System.out.println();
		}
	}
	
	//카드번호 보여주기
	void printCard() {
		//배열선언
		int[] intArray = new int[16];
		//1 ~ 16까지의 임의수 할당
		for (int i = 0; i < intArray.length; i++) {
			int index = -1;
			int ranNum = (int)(Math.random() * 16) + 1;
			for (int j = 0; j < intArray.length; j++) {
				if (intArray[j] == ranNum) {
					index = j;
					break;
				}
			}
			if (index == -1) {
				intArray[i] = ranNum;
			} else i--;
		}

		//버블 정렬
		for (int i = intArray.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (intArray[j] > intArray[j + 1]) {
					int temp = intArray[j];
					intArray[j] = intArray[j + 1];
					intArray[j + 1] = temp;
				}
			}
		}
		
		
		//출력
		for (int i = 0; i < intArray.length; i++) {
			System.out.printf("%3d", intArray[i]);
			if (i % 4 == 3) {
				System.out.println();
			}
		}
	}
}
