package com.clarion.sacumen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final Set<String> PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json")); 
	ApiInfo apiInfo = new ApiInfo("Clarion-Sacumen machine test API", "Sacumen machine test API to get the download_url value and get the CSV data and extract the Issue id from the CSV.", "1.0", "urn:tos",
	          "rajrusia33@gmail.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	@Bean
	public Docket sacumenTestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).produces(PRODUCES_AND_CONSUMES).consumes(PRODUCES_AND_CONSUMES);
	}
}
