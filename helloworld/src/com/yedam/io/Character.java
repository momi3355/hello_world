package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class Character {
	private static void writer() {
		try {
			Writer writer = new FileWriter("c:/temp/data.txt");
			writer.write('a');
			writer.write('b');
			writer.write('c');
			writer.write('t');
			writer.write('y');
			writer.write('z');
			for (int i = 1; i <= 5; i++)
				writer.write('z'+i);
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void read() {
		try {
			Reader reader = new FileReader("src/com/yedam/io/StreamExe.java");
			
			while (true) {
				int data = reader.read();
				if (data == -1) break;
				System.out.print((char)data);
			}
			System.out.println();
			
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력 중 오류가 발생했습니다.");
		}
	}
	private static void writer2() {
		Scanner scn = new Scanner(System.in);
		try {
			Writer writer = new FileWriter("c:/temp/message.txt");
			while (true) {
				System.out.print("입력>>_");
				String msg = scn.nextLine();
				if (msg.equals("quit")) break;
				writer.write(msg+"\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("입출력 중 오류가 발생했습니다.");
		} finally {
			scn.close();
		}
	}
	public static void main(String[] args) {
		/* 'Scanner'가 파일을 읽을 수 있다. */
		try {
			Scanner reader = new Scanner(new FileInputStream("c:/temp/message.txt"));
			while (reader.hasNext()) {
				String msg = reader.nextLine();
				String[] values = msg.split(" "); //구분자가 ' '이다.
				System.out.println(
						"코드: "+values[0]
						+ ", 이름: "+values[1]
						+ ", 가격: "+values[2]);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
		
		System.out.println("end of prog.");
	}
}
