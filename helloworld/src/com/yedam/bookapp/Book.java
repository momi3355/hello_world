package com.yedam.bookapp;

public class Book {
	private String title;
	private String author;
	private String publisher;
	private int price;
	private int orderNo;
	
	public Book() { /* null */ }
	public Book(Book b) {
		setBook(b);
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getPrice() {
		return price;
	}
	public int getOrderNo() {
		return orderNo;
	}

	public void setBook(Book b) {
		setTitle(b.getTitle());
		setAuthor(b.getAuthor());
		setPublisher(b.getPublisher());
		setPrice(b.getPrice());
	}
	
	void setTitle(String title) {
		this.title = title;
	}
	void setAuthor(String author) {
		this.author = author;
	}
	void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	void setPrice(int price) {
		this.price = price;
	}
	void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	public String showList() {
		return title+"\t"+author+"\t"+price;
	}
	public String showList(int titleLength, int authorLength) {
		String str = getTitle();
		for (int i = getTitle().length(); i < titleLength; i++)
			str += " ";
		str += "\t"+author;
		for (int i = getAuthor().length(); i < authorLength; i++)
			str += " ";
		str += "\t"+price;
		return str;
	}
	
	public String showListWithNo() {
		return orderNo+"\t"+title+"\t"+author+"\t"+price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book temp = (Book)obj;
			if (this == obj) return true;
			return getTitle().equals(temp.getTitle())
					&& getAuthor().equals(temp.getAuthor())
					&& getPublisher().equals(temp.getPublisher())
					&& getPrice() == temp.getPrice();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", price=" + price + "]";
	}
}
