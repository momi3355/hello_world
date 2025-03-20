package com.yedam.classes;

import java.io.Serializable;

/*
 * 상품코드, 상품명, 가격
 */
public class Product implements Serializable {
	private String code;
	private String name;
	private int price;
	
	public Product() { /* null */ }
	public Product(Product p) {
		this(p.code, p.name, p.price);
	}
	public Product(String _code, String _name, int _price) {
		code = _code;
		name = _name;
		price = _price;
	}
	
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String showProduct() {
		return getCode()+" "+getName()+" "+getPrice();
	}
	
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + "]";
	}
}
