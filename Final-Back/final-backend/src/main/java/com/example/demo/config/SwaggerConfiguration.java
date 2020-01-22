package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    // URL DE SWAGGER http://localhost:8090/swagger-ui.html
    @Bean // Anotación que marca como bean cada uno de los métodos de tal forma que esten disponibles para Spring
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/api/.*"))
                .build()
                .apiInfo(apiInfo()); //define la documentacion del servicio, informacion..
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API TECH TALK",
                "API TECH TALK SWAGGER",
                "v1.0",
                " ",
                new Contact("Guido Huechumilla","", "guido.huechumilla@outlook.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

}
