package com.tt.memento;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tt.memento.dao")
public class MementoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MementoApplication.class, args);
	}
}
