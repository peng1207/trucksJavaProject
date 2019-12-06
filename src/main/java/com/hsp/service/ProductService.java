package com.hsp.service;

import java.util.List;

import com.hsp.model.Product;
import com.hsp.model.User;
 
public interface ProductService {
	
	List<Product> getAll();
	Product findById(String id);
	int insertData(String name, String userid);
	int updateData(User user);
}
