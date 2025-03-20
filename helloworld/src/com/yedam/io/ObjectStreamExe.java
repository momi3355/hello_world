package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.yedam.classes.Product;

public class ObjectStreamExe {
	private static void write() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product("A001", "연필", 1000));
		list.add(new Product("B001", "지우개", 500));
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(list);
			oos.flush();
			
			fos.close(); oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	}
	
	public static void main(String[] args) {
		//객체 -> byte : 직렬화.
		//byte -> 객체 : 역직렬화.
		//클래스 implements Serializable(인터페이스)
		
		try {
			FileInputStream fis = new FileInputStream("c:/temp/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object source = ois.readObject();
			List<Product> list = new ArrayList<Product>();
			
			//source 타입 체크
			if (source instanceof List) {
				List<?> temp = ((List<?>)source);
				for (int i = 0; i < temp.size(); i++)
					if (temp.get(i) instanceof Product)
						list.add((Product)temp.get(i));
			}
			for (Product p : list)
				System.out.println(p.showProduct());
			fis.close(); ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력 중에 애러가 발생했습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("객체를 찾을 수 없습니다.");
		}
		System.out.println("end of prog.");
	}
}
