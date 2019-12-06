package com.hsp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hsp.sql")
public class TrucksApplication {
	public static void main(String[] args) {
		System.out.println("启动服务了");
		SpringApplication.run(TrucksApplication.class, args);
	}
}
