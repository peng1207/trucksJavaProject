package com.hsp.service;

import java.util.List;

import com.hsp.model.Product;
 
public interface ProductService {
	
	List<Product> getAll();
	Product findById(String id);
}
