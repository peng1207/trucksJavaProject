package com.hsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.model.Product;
import com.hsp.service.ProductService;
import com.hsp.sql.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	 @Autowired
	 private ProductMapper productMapper;
	  
	 
	public List<Product> getAll(){
		// TODO Auto-generated method stub
		System.out.println(productMapper);
		return productMapper.getAll();
	}

	
}
