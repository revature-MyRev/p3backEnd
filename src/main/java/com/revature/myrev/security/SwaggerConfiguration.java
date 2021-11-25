package com.revature.myrev.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * This class configures Swagger UI to include a JWT when it calls the API.
 * Referenced "Set JWT with Spring Boot and Swagger UI" tutorial at https://www.baeldung.com/spring-boot-swagger-jwt
 *
 */
@Configuration
public class SwaggerConfiguration {

	private static final String AUTHORIZATION_HEADER = "Authorization";
	
	/**
	 * Defines ApiInfo for this app
	 * 
	 * @return new ApiInfo
	 */
	private ApiInfo apiInfo () {
		return new ApiInfo("My REST API", 
				"Project 3",
				"1.0", "Terms of Service",
				new Contact("name", "url", "email"),
				"Liscense of API",
				"API License URL",
				Collections.emptyList());
	}
	
	/**
	 * Configures the API Docket to include API info, security contexts, & security schemes
	 * 
	 * @return An API Docket that includes JWT global authorization
	 */
	@Bean
	public Docket api () {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
    }
	
	/**
	 * Defines the ApiKey to include JWT as an authorization header.
	 * 
	 * @return A new ApiKey
	 */
	private ApiKey apiKey () {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}
	
	/**
	 * Adds the global JWT authorization from the defautAuth's returned SecurityReference to the Security Context
	 * @return
	 */
	private SecurityContext securityContext () {
		return SecurityContext.builder()
				.securityReferences(defaultAuth())
				.build();
	}
	
	/**
	 * Sets the JWT authorization scope to global
	 * 
	 * @return A security reference that gives "JWT" global authorization
	 */
	List<SecurityReference> defaultAuth () {
		AuthorizationScope authorizationScope 
		    = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
}
