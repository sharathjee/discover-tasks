package com.discover.deposits.cvd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CvdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvdApplication.class, args);
	}

}
