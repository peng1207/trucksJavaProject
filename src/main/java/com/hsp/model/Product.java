package com.hsp.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class Product {
	public String title;
	public String price;
	public String id;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
