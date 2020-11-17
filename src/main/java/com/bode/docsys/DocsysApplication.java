package com.bode.docsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bode.docsys.mapper")
public class DocsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocsysApplication.class, args);
	}

}
