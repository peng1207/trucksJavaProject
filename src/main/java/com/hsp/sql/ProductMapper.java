package com.hsp.sql;

import java.util.List;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hsp.model.Product;
@Component
//@Repository(value = "productMapper")
public interface ProductMapper {
	@Select("select title,price,id from product")
	@Results({
			@Result(property = "id",column = "id")
	})
	List<Product> getAll();
}
