package com.tqi.credito;

import com.tqi.credito.mappers.ClienteMapper;
import com.tqi.credito.mappers.EmprestimoMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditoApplication.class, args);
	}

}
