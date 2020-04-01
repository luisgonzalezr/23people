package com.prueba.people;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	
	@Bean
	public WebMvcConfigurer consConfigurer() {
	return new WebMvcConfigurer() {
	
@Override
public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**")
	.allowedMethods("GET","POST", "PUT", "DELETE")
	.allowedHeaders("*")
	.allowedOrigins("https://peoplex.herokuapp.com:8040");
}
	};
	
}
	
	
}
