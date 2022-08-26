package com.lms.api;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class LmsBackendSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsBackendSystemApplication.class, args);
	}

}
