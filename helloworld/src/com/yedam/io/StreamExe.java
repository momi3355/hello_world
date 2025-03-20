package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class StreamExe {
	private static void write() {
		//출력스트림(바이트)
		try {
			OutputStream os = new FileOutputStream("c:/temp/data.bin");
			os.write(10);
			os.write(20);
			os.write(30);
			for (int i = 0; i < 10; i++)
				os.write(65+i);
			os.flush();
			os.close();
		} catch (IOException e) {
			System.out.println("입출력 중 오류가 발생했습니다.");
		}
	}
	
	private static void read() {
		//입력스트림(바이트).
		try {
			InputStream is = new FileInputStream("c:/temp/data.bin");
			while (true) {
				int data = is.read();
				if (data == -1) break;
				System.out.print(data+" ");
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("입출력 중 오류가 발생했습니다.");
		}
	}
	
	private static void copy() {
		//입력 + 출럭 -> 복사.
		try {
			InputStream is = new FileInputStream("c:/temp/image.jpg");
			OutputStream os = new FileOutputStream("c:/temp/image3.jpg");
			
			int c = 0;
			byte[] buf = new byte[100];
			while (true) {
				int data = is.read(buf);
				if (data == -1) break;
				os.write(buf);
				//String code = String.format("%3d", data);
				//System.out.print(code+" "+(++c % 20 == 0 ? "\n" : ""));
				//System.out.println(Arrays.toString(buf));
			}
			System.out.println();
			is.close();
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력 중 오류가 발생했습니다.");
		}
	}
	
	public static void main(String[] args) {
		copy();
		System.out.println("end of prog.");
	}
}
