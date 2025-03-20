package com.yedam.classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MethodExe2 {
	
	private List<Product> store = new ArrayList<Product>();
	
	public MethodExe2() {
		init();
//		store.add(new Product("A001", "지우개", 500));
//		store.add(new Product("A002", "지우개", 700));
//		store.add(new Product("B001", "샤프", 1000));
//		store.add(new Product("B002", "샤프", 1500));
//		store.add(new Product("C001", "연필", 500));
//		store.add(new Product("C002", "연필", 300));
	}
	
	public void init() {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object source = ois.readObject();
			
			//source 타입 체크
			if (source instanceof List) {
				List<?> temp = ((List<?>)source);
				for (int i = 0; i < temp.size(); i++) {
					Object item = temp.get(i);
					if (item instanceof Product)
						store.add((Product)item);
				}
			}
			ois.close(); fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력 중에 애러가 발생했습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("객체를 찾을 수 없습니다.");
		}
	}
	
	// 종료시점에 store 정보를 message.txt에 저장
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(store);
			oos.flush();
			
			fos.close(); oos.close();
		} catch (IOException e) {
			System.out.println("입출력 중 오류가 발생했습니다.");
		}
	}
	
	public boolean add(Product prd) {
		return store.add(prd);
	}
	
	public boolean modify(Product prd) {
		//prd에는 "code"만 있는 데이터고, 나머지는 바꿀 데이터를 가지고 있다.
		for (int i = 0; i < store.size(); i++) {
			Product p = store.get(i);
			if (p.getCode().equals(prd.getCode())) {
				if (prd.getName() != null) p.setName(prd.getName());
				if (prd.getPrice() != 0)   p.setPrice(prd.getPrice());
				return true;
			}
		}
		return false;
	}
	
	public Product remove(String code) {
		for (int i = 0; i < store.size(); i++) {
			Product p = store.get(i);
			//Product* p = &store[i]; 이거랑 동일하다.
			// 그래서 p = null 해도 원본이 삭제가 되지 않는다.
			if (p.getCode().equals(code)) {
				Product temp = p; //p는 연결이 끊어질 예정이니 temp에 연결해준다.
				store.remove(i);
				return temp;
			}
		}
		return null;
	}
	public List<Product> getStore() {
		return store;
	}
	public List<Product> getStore(String name) {
		if ("ALL".equalsIgnoreCase(name)) //모두 조회
			return getStore();
		List<Product> list = new ArrayList<Product>();
		store.forEach(p -> {
			if (p.getName().equals(name)) list.add(p);
		});
		return list;
	}
	public List<Product> getStore(Product prd) {
		List<Product> list = new ArrayList<Product>();
		for (int i = 0; i < store.size(); i++) {
			Product p = store.get(i);
			if ("ALL".equalsIgnoreCase(prd.getName()) || //'ALL'이거나 이름이 같을 때.
							p.getName().equals(prd.getName()) || p.getCode().equals(prd.getCode())) {
				if (p.getPrice() >= prd.getPrice()) {
					list.add(p);
				}
			}
		}
		return list;
	}
	
	public void showList() {
		store.forEach(p -> System.out.println(p.showProduct()));
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < store.size(); i++) {
			str += (i+1)+". "+store.get(i)+"\n";
		}
		return str;
	}
}
