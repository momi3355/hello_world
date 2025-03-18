package com.yedam.classes;

import java.util.List;
import java.util.Scanner;

public class ProductManager {
	private Scanner scn = new Scanner(System.in);
	private MethodExe2 store = new MethodExe2();

	public void showList() {
		System.out.println("코드  이름   가격");
		System.out.println("==============");
		store.showList();
		System.out.println();
	}
	public void add() {
		System.out.print("추가할 제품코드 >_");
		String code = scn.nextLine();
		if (store.getStore(new Product(code, null, 0)).size() > 0) {
			System.out.println("제품코드가 이미 존재합니다.");
			return;
		}
		System.out.print("추가할 제품이름 >_");
		String name = scn.nextLine();
		
		int price = 0;
		do {
			System.out.print("추가할 제품가격 >_");
			price = Integer.parseInt(scn.nextLine());
			if (price <= 0)
				System.out.println("가격은 0보다 커야합니다.");
		} while (price <= 0);
		
		store.add(new Product(code, name, price));
		System.out.println("제품이 성공적으로 추가가 되었습니다.");
	}
	
	public void modify() {
		System.out.print("수정할 제품코드 >_");
		String code = scn.nextLine();
		List<Product> list = store.getStore(new Product(code, null, 0));
		if (list.isEmpty()) {
			System.out.println("제품코드를 찾지 못했습니다.");
			return;
		}
		Product modify = list.getFirst();
		//무엇을 수정할줄 모르기때문에 기본정보를 먼저 삽입한다.
		String name = modify.getName();
		int price = modify.getPrice();
		System.out.println("무엇을 수정하시겠습니까?");
		System.out.println("1.이름 2.가격 3.둘다.");
		int menu = Integer.parseInt(scn.nextLine());
		switch (menu) {
		case 1: case 3:
			System.out.print("이름 >_");
			name = scn.nextLine();
			if (menu == 1) break;
		case 2:
			do {
				System.out.print("가격 >_");
				price = Integer.parseInt(scn.nextLine());
				if (price <= 0)
					System.out.println("가격은 0보다 커야합니다.");
			} while (price <= 0);
			break;
		default:
			System.out.println("숫자를 잘못 입력 하셨습니다.");
			break;
		}
		modify.setName(name);
		modify.setPrice(price);
		System.out.println("성공적으로 수정이 되었습니다.");
	}
	
	public void remove() {
		System.out.print("삭제할 제품코드 >_");
		String code = scn.nextLine();
		Product remove = store.remove(code);
		if (remove == null) {
			System.out.println("제품코드를 찾지 못했습니다.");
			return;
		}
		System.out.println("성공적으로 삭제가 되었습니다.");
	}
	
	public void run() {
		//사용자 입력을 받아서 1.목록 2.추가 3.수정 4.삭제, 9.종료 구현; 
		// 입력메세지 정의 구현.
		
		boolean run = true;
		while (run) {
			System.out.println("메뉴를 선택하세요..");
			System.out.println("1.목록 2.추가 3.수정 4.삭제, 9.종료");
			System.out.print(">>_");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			case 1: showList(); break;
			case 2: add()     ; break;
			case 3: modify()  ; break;
			case 4: remove()  ; break;
			case 9:
				run = false;
				break;
			default:
				System.out.println("숫자를 잘못 입력 하셨습니다.");
				break;
			}
		}
		System.out.println("end of prog.");
	}
}
