package com.yedam.bookapp;

public class BookBuilder {
	private	String bookCode;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private int orderNo;
	
	public BookBuilder() {
		
	}
	public BookBuilder(String title) {
		this.title = title;
	}
	
	public BookBuilder setBookCode(String bookCode) {
		this.bookCode = bookCode;
		return this;
	}
	public BookBuilder setTitle(String title) {
		this.title = title;
		return this;
	}
	public BookBuilder setAuthor(String author) {
		this.author = author;
		return this;
	}
	public BookBuilder setPublisher(String publisher) {
		this.publisher = publisher;
		return this;
	}
	public BookBuilder setPrice(int price) {
		this.price = price;
		return this;
	}
	public BookBuilder setOrderNo(int orderNo) {
		this.orderNo = orderNo;
		return this;
	}
	
	public Book build() {
		Book b = new Book();
		b.setTitle(title);
		b.setAuthor(author);
		b.setPublisher(publisher);
		b.setPrice(price);
		b.setBookCode(bookCode);
		b.setOrderNo(orderNo);
		return b;
	}
}
