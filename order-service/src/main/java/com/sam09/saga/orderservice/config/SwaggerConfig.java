package com.sam09.saga.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author soumya
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket(){
		String basePackage = "com.sam09.saga.orderservice.controller";
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"SAGA-Pattern Demonstration with Event Sourcing", 
				"Here we have leveraged Spring boot as a means of our services and we have use AXON framework", 
				"1.0.0",
				"TnC",
				"",
				"", 
				"");
	}
}
