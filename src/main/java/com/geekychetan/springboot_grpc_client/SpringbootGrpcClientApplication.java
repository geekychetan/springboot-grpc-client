package com.geekychetan.springboot_grpc_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootGrpcClientApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SpringbootGrpcClientApplication.class, args);
		ApplicationContext context = SpringApplication.run(SpringbootGrpcClientApplication.class, args);
		UserClientService userClientService = context.getBean(UserClientService.class);
		userClientService.getUser();
	}

}
