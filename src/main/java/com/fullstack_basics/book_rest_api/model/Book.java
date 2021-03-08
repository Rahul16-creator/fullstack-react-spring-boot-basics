package com.fullstack_basics.book_rest_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_tbl")
public class Book {
    
	@Id
	@GeneratedValue
	private int id;

	private String title;
	private String author;
	private Long isbnNumber;
	private Double price;
	private String Language;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getIsbnNumber() {
		return isbnNumber;
	}
	public void setIsbnNumber(Long isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	
	
}
