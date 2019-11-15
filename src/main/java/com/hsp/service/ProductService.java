package com.hsp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hsp.model.Product;
 
public interface ProductService {
	
	List<Product> getAll();
	
}
