package com.api.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de ejecución de la aplicación de spring
 */
@SpringBootApplication
public class JpaApiDemoApplication {

	/**
	 * Método principal para levantar el servidor con el microservicio
	 */
	public static void main(String[] args) {
		SpringApplication.run(JpaApiDemoApplication.class, args);
	}

}
