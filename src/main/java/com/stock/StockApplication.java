package com.stock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * 
 * @Author Ekpe, Joseph Martin
 */
@SpringBootApplication
public class StockApplication {

	private static final Logger logger = LoggerFactory.getLogger(StockApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
		logger.info("Stock Application Started successfully!");
	}

}
