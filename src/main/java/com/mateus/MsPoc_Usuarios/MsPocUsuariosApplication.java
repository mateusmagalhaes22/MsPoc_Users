package com.mateus.MsPoc_Usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsPocUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPocUsuariosApplication.class, args);
	}

}
