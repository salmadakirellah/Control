package com.dakirellah.dakirellah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

 
@SpringBootApplication
@EntityScan(basePackages = "com.dakirellah.dakirellah.entities")
public class DakirellahApplication {

	public static void main(String[] args) {
		SpringApplication.run(DakirellahApplication.class, args);
	}

}
