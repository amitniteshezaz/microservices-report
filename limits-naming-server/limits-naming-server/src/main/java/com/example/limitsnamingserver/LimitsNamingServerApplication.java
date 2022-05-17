package com.example.limitsnamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LimitsNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsNamingServerApplication.class, args);
	}

}
