package com.project.carmotor.carmotor;

import com.project.carmotor.carmotor.Controller.CarController;
import com.project.carmotor.carmotor.Domain.CarValidator;
import com.project.carmotor.carmotor.Service.CarService;
import com.project.carmotor.carmotor.Service.ClientService;
import com.project.carmotor.carmotor.Service.MotorService;
import com.project.carmotor.carmotor.Service.TransactionService;
import com.project.carmotor.carmotor.UI.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;


@ComponentScan({"com.project.carmotor.carmotor", "com.project.carmotor.carmotor.Repository"})
@SpringBootApplication
@EntityScan("com.project.carmotor.carmotor.Domain")
@EnableJpaRepositories(basePackages = "com.project.carmotor.carmotor.Repository")
public class CarmotorApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CarmotorApplication.class, args);

		Console console = context.getBean(Console.class);
		console.runConsole();
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}