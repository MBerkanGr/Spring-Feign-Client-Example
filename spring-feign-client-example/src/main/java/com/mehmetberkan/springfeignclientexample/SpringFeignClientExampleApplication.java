package com.mehmetberkan.springfeignclientexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class SpringFeignClientExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignClientExampleApplication.class, args);
	}

}