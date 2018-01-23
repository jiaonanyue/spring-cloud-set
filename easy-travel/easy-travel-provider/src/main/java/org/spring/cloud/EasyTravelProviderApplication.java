package org.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EasyTravelProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyTravelProviderApplication.class, args);
	}
}
