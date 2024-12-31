package com.hamitmizrak.techcareer_2025_backend_1.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerBean {

    // Swagger
    @Bean
    public OpenAPI getOpenAPIMethod() {
        return new OpenAPI().info(new Info()
                .title("Master Computer Engineer Hamit Mızrak")
                .version("V1.0.0")
                //.summary(" for spring boot on react js, auth: "+hashCode())
                .description("Spring Boot & React Js & Devops")
                .termsOfService(" Software INC")
                .contact(new Contact()
                        .name("Hamit Mızrak")
                        .email("hamitmizrak@gmail.com")
                        .url("https://github.com/HamitMizrak")
                )
                .license(new License()
                        .name("licence INC xyz")
                        .url("https://github.com/HamitMizrak")
                )
        ); //end return new OpenAPI()
    } //end method
} //end class

