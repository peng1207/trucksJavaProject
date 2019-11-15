package com.hsp.controller;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.hsp.model.Product;
import com.hsp.model.User;
import com.hsp.service.ProductService;
 
@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired(required=true)
	@Qualifier("productServiceImpl")
	ProductService productService;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	@ResponseBody
	public Object login(User user1) {
		System.out.println("name is " + user1.name +"、" +"address is "+ user1.address +"、"+ "age is "+ user1.age);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "0");
		map.put("msg", "获取成功");
		User user = new User();
		user.name = "张三";
		user.age = 20; 
		user.address = "广东省深圳市南山区西丽";
		map.put("data", user);
	 
		return map;
	}
	@RequestMapping(value = "/resgister",method = RequestMethod.POST)
	@ResponseBody
	public Object resgister(@RequestBody User user1) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Product> list = productService.getAll();
			System.out.println(JSON.toJSONString(list));
			map.put("list", list);
			map.put("code", "0");
			map.put("msg", "获取成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("code", "1");
			map.put("msg", "获取失败");
		}
		return map;
	}
	

}
