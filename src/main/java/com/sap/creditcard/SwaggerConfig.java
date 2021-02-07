package com.sap.creditcard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The creditcard Swagger config.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * This is swagger Config which is used to generate Swagger of API
     *
     * <p>Swagger can be refered from below endpoint in browser: http://localhost:8080/swagger-ui.html
     *
     * @return the docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sap.creditcard"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "CreditCardProcessingSystem",
                "This Restful API allows you to add new credit card accounts and view them as a list.",
                "v1",
                "Terms of service",
                "nehagupta.pandey@gmail.com",
                "License of API",
                "https://swagger.io/docs/");
    }
}
