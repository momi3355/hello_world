package com.yedam.api;

public class SystemExe {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				System.out.println("종료합니다.");
				//System.exit(0);
				//break;
			}
		}
		
		long start = System.nanoTime();
		long sum = 0;
		for (int i = 1; i < 10000000; i++) {
			sum += i;
		}
		long end = System.nanoTime();
		System.out.println("1~10000000까지의 합 "+sum);
		System.out.println("걸린시간 "+((end-start)/1000000.0)+"ms");
		System.out.println("end of prog.");
	}
}
