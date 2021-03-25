/**
 * 
 */
package com.digital.cart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author M1056182
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
	
	
	@SuppressWarnings("unused")
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "My REST API", 
	      "Shopping Cart.", "", 
	      "Terms of service", 
	      new Contact("Nithin Kambesh", "M1056182", "nithin.kambesh@company.com"), 
	      "License of API", "API license URL", null);
	}

}
