package com.hsp.sql;

import java.util.List;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import com.hsp.model.Product;
import com.hsp.model.User;
@Component
public interface ProductMapper {
	@Select("select title,price,id,unit_id from product")
	@Results({
			@Result(property = "id",column = "id"),
			@Result(property = "unitId",column = "unit_id")
	})
	List<Product> getAll();
	
	@Select("Select title,price,id from product where id =#{id}")
	Product findById(@Param(value = "id") String id);
	
	@Insert("insert into sp_test2(name,user_id) values(#{name},#{userid})")
	int insertData(@Param(value = "name") String name,@Param(value = "userid") String userid);
	@Update("update sp_test2 set name = #{name} where user_id = #{user_id}")
	int updateData(User user);
}


/*
 *  如何防止接口攻击
 * 
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 **/
 