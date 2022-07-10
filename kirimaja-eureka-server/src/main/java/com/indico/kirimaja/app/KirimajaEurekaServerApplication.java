package com.indico.kirimaja.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class KirimajaEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KirimajaEurekaServerApplication.class, args);
	}

}
