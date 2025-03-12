package com.yedam.bookapp;

public class BookBuilder {
	private Book book;
	
	public BookBuilder() {
		book = new Book();
	}
	public BookBuilder(String title) {
		book = new Book();
		book.setTitle(title);
	}
	
	public BookBuilder setTitle(String title) {
		book.setTitle(title);
		return this;
	}
	public BookBuilder setAuthor(String author) {
		book.setAuthor(author);
		return this;
	}
	public BookBuilder setPublisher(String publisher) {
		book.setPublisher(publisher);
		return this;
	}
	public BookBuilder setPrice(int price) {
		book.setPrice(price);
		return this;
	}
	public BookBuilder setOrderNo(int orderNo) {
		book.setOrderNo(orderNo);
		return this;
	}
	
	public Book build() {
		return book;
	}
}
