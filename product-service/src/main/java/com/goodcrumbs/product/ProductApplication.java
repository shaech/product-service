package com.goodcrumbs.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);

		System.out.println("Hi Shachi");


		System.out.println(System.getProperty("java.class.path"));
		System.out.println(ProductApplication.class.getClassLoader());
		System.out.println(ProductApplication.class.getProtectionDomain().getCodeSource().getLocation());
	}

}
