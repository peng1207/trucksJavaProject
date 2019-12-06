package com.hsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsp.model.Product;
import com.hsp.model.User;
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
	public Product findById(String id) {
		// TODO Auto-generated method stub
		return productMapper.findById(id);
	}
	@Transactional(rollbackFor = RuntimeException.class)
	public int insertData(String name, String userid) {
		// TODO Auto-generated method stub
		int result =  productMapper.insertData(name, userid);
		return result;
	}
	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public int updateData(User user) {
		// TODO Auto-generated method stub
		return productMapper.updateData(user);
	}
}
