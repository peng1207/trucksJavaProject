package com.hsp.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hsp.model.Product;
import com.hsp.service.ProductService;
import com.hsp.sql.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	 @Autowired
//	 @Qualifier("productMapper")
	 private ProductMapper productMapper;
	  
	 
	public List<Product> getAll(){
		// TODO Auto-generated method stub
		System.out.println(productMapper);
		return productMapper.getAll();
//		return null;
	}

	
}
