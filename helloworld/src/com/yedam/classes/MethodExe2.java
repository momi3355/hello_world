package com.yedam.classes;

public class MethodExe2 {
	private static final int DEFAULT_SIZE = 10;
	
	private Product[] store;
	
	public MethodExe2() {
		store = new Product[DEFAULT_SIZE];
		store[0] = new Product("A001", "지우개", 500);
		store[1] = new Product("A002", "지우개", 700);
		store[2] = new Product("B001", "샤프", 1000);
		store[3] = new Product("B002", "샤프", 1500);
		store[4] = new Product("C001", "연필", 500);
		store[5] = new Product("C002", "연필", 300);
	}
	
	public boolean add(Product prd) {
		for (int i = 0; i < store.length; i++) {
			if (store[i] == null) {
				store[i] = prd;
				return true;
			}
		}
		return false;
	}
	
	public boolean modify(Product prd) {
		//prd에는 "code"만 있는 데이터고, 나머지는 바꿀 데이터를 가지고 있다.
		for (int i = 0; i < store.length; i++) {
			Product p = store[i];
			if (p != null && p.getCode().equals(prd.getCode())) {
				if (prd.getName() != null)
					p.setName(prd.getName());
				if (prd.getPrice() != 0)
					p.setPrice(prd.getPrice());
				return true;
			}
		}
		return false;
	}
	
	public Product remove(String code) {
		for (int i = 0; i < store.length; i++) {
			Product p = store[i];
			//Product* p = &store[i]; 이거랑 동일하다.
			// 그래서 p = null 해도 원본이 삭제가 되지 않는다.
			if (p != null && p.getCode().equals(code)) {
				Product temp = p; //p는 연결이 끊어질 예정이니 temp에 연결해준다.
				store[i] = null;
				return temp;
			}
		}
		return null;
	}
	
	public Product[] getStore() {
		return store;
	}
	public Product[] getStore(String name) {
		if ("ALL".equalsIgnoreCase(name)) //모두 조회
			return getStore().clone();
		Product[] list = new Product[DEFAULT_SIZE];
		int list_idx = 0;
		for (int i = 0; i < store.length; i++) {
			Product p = store[i];
			if (p != null && p.getName().equals(name)) {
				list[list_idx++] = p;
			}
		}
		return list;
	}
	public Product[] getStore(Product prd) {
		Product[] list = new Product[DEFAULT_SIZE];
		int list_idx = 0;
		for (int i = 0; i < store.length; i++) {
			Product p = store[i];
			if (p != null &&
					//'ALL'이거나 이름이 같을 때.
					("ALL".equalsIgnoreCase(prd.getName()) || p.getName().equals(prd.getName()))) {
				if (p.getPrice() >= prd.getPrice()) {
					list[list_idx++] = p;
				}
			}
		}
		return list;
	}
	
	public void showList() {
		for (int i = 0; i < store.length; i++) {
			Product p = store[i];
			if (p != null) {
				System.out.println(p.showProduct());
			}
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < store.length; i++) {
			Product p = store[i];
			if (p != null) str += (i+1)+". "+p+"\n";
		}
		return str;
	}
}
