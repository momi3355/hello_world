package com.yedam.classes;

public class MethodMain {
	
	static void officeApp() {
		new ProductManager().run();
	}
	
	void method1() {
		MethodExe1 mx1 = new MethodExe1();
//		System.out.println(mx1);
		System.out.print("si");
		mx1.printString(20, "u");
		
		String result1 = mx1.sum(Integer.valueOf(1570), Integer.valueOf(2413)).toString();
		System.out.println(result1);

		String result2 = mx1.sum(Double.valueOf(15.45), Double.valueOf(24.13)).toString();
		System.out.println(result2);
		
		String result3 = mx1.sum("123", "456").toString();
		System.out.println(result3);
		
		int result4 = mx1.sum(new int[] { 1, 40, 2, 60, 43, 22 });
		System.out.println(result4);
		
		double result5 = mx1.sum(new double[] { 1.2, 40.25, 2.252, 60.3557, 43.2268, 22.1253 });
		System.out.println(result5);
		
		int test1 = mx1.test(1, 1, 1, 1, 1);
		System.out.println(test1);
	}
	
	void method2() {
		//상품코드 : M001,
		// 상품명 : 만년필,
		//  가격 : 10000;
		MethodExe2 mx2 = new MethodExe2();
		mx2.add(new Product("M001", "만년필", 10000));
		mx2.add(new Product("M002", "형광팬", 4000));
		//System.out.print(mx2);
		Product removeE = mx2.remove("B001");
		System.out.print("삭제된 개체(Entity): ");
		System.out.println(removeE.showProduct()+"\n");
		
//		Product prod = new Product("A001", null, 1000);
//		mx2.modify(prod);
		
		Product search = new Product();
		search.setName("지우개");
		//search.setPrice(700); // >= 700;
		
		Product[] list = mx2.getStore(search);
		for (int i = 0; i < list.length; i++) {
			Product p = list[i];
			if (p != null) {
				System.out.println(p.showProduct());
			}
		}
	}
	
	void method3() {
		MethodExe3 mx3 = new MethodExe3();
//		System.out.println(mx3.gugudan(10, 100));
		mx3.printStar(5, "*");
		mx3.printCard();
	}
	
	void method4() {
		MethodExe4 mx4 = new MethodExe4();
		mx4.main();
	}
	
	public static void main(String[] args) {
		officeApp();
	}
}
