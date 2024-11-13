package com.discover.deposit.discover_demo_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscoverDemo1Application {

	Logger logger = LoggerFactory.getLogger(DiscoverDemo1Application.class);

	public static void main(String[] args) {

		SpringApplication.run(DiscoverDemo1Application.class, args);
	}

}
