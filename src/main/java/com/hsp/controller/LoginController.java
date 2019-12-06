package com.hsp.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.hsp.model.Product;
import com.hsp.model.User;
import com.hsp.service.ProductService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

 
 
@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired(required = true)
	@Qualifier("productServiceImpl")
	ProductService productService;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public Object login(User user1) {
		user_print(user1);
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
	private void user_print(User user1) {
		System.out.println("name is " + user1.name +"、" +"address is "+ user1.address +"、"+ "age is "+ user1.age + "、user_id is" + user1.user_id );
	}
//	@RequestMapping(value = "/resgister",method = RequestMethod.POST)
	@PostMapping(value = "/resgister")
	public Object resgister(@RequestBody User user1) {
		user_print(user1);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Product> list = productService.getAll();
			System.out.println(JSON.toJSONString(list));
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("list", list);
			map.put("data", dataMap);
			map.put("code", "0");
			map.put("msg", "获取成功");
			System.out.println(JSON.toJSONString(productService.findById("02c17dd1640a2692e4beded250b9152d")));
			System.out.println(productService.updateData(user1));
			System.out.println(productService.insertData("张三", "1"));
		   
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("code", "1");
			map.put("msg", "获取失败");
		}
		 
		return map;
	}
	

}
