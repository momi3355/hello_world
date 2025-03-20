package com.yedam.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExe {
	public static void main(String[] args) {
		File file = new File("c:/temp/new.txt");
		File folder = new File("c:/temp/images/") ;
		try {
			if (!file.exists()) { //존재여부
				file.createNewFile(); //파일 생성.
				System.out.println("파일이 생성이 되었습니다.");
			}
			
			if (!folder.exists()) {
				folder.mkdirs();
				System.out.println("폴더(디렉토리)가 생성이 되었습니다.");
			}
			
			if (folder.exists()) {
				File[] data = folder.listFiles();
				for (int i = 0; i < data.length; i++) {
					System.out.println(data[i].getName());
				}
			}
			
			FileWriter fw = new FileWriter(file); //입출력스트림의 매개값.
			fw.write("Hello ");
			fw.write("world\n");
			
			fw.flush(); fw.close();
			
			if (file.exists()) {
				file.delete();
				System.out.println("파일이 제거되었습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	}
}
