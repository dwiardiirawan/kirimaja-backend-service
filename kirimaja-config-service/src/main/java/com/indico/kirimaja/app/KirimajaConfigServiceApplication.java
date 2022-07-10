package com.indico.kirimaja.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class KirimajaConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KirimajaConfigServiceApplication.class, args);
	}

}
