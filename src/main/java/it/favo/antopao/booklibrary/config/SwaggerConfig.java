package it.favo.antopao.booklibrary.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/").apiInfo(metaData());
	}

	private ApiInfo metaData() {
		Contact contact = new Contact("Antonella Favorito", "", "antonellafavorito@gmail.com");

		return new ApiInfo("Book Library", //
				"Sparagn&Cumparisc", //
				"1.0", //
				"Terms of Service: tbd", //
				contact, //
				"Apache License Version 2.0", //
				"https://www.apache.org/licenses/LICENSE-2.0", //
				new ArrayList<>());
	}

}
