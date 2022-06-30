package com.supervisormanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SupervisorManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupervisorManagementApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public WebMvcConfigurer crosConfiguration() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods(CorsConfiguration.ALL)
						.allowedHeaders(CorsConfiguration.ALL)
						.allowedOriginPatterns(CorsConfiguration.ALL);
			}
		};
	}

}
