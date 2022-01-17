package com.example;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
public class RestaurantesApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(RestaurantesApplication.class, args);
	}
	
	

}
