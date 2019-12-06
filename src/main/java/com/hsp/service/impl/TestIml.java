package com.hsp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hsp.model.Product;
import com.hsp.model.User;
import com.hsp.service.ProductService;
@Service
public class TestIml implements ProductService {
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		System.out.println("进入方法中");
		return null;
	}
	public Product findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public int insertData(String name, String userid) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateData(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
}
