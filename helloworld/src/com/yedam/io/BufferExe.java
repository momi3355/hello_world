package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferExe {
	static void write() {
		
	}
	
	public static void main(String[] args) {
		try {
			//입력스트림
			FileInputStream fis = new FileInputStream("‪c:/Users/admin/Downloads/jdk-21_windows-x64_bin.exe");
			BufferedInputStream bis = new BufferedInputStream(fis);
			//출력스트림
			FileOutputStream fos = new FileOutputStream("‪c:/temp/jdk-21_windows-x64_bin.exe");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			long start = System.nanoTime();
			while (true) {
				int data = bis.read();
				if (data == -1) break;
				bos.write(data);
				bos.flush();
			}
			long end = System.nanoTime();
			System.out.println("걸린시간 "+((end-start)/1000000.0)+"ms");
			
			fis.close();bis.close();
			fos.close();bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
