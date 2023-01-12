package com.ssg.sausagememberapi.common.config.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Item API Docs")
                .version("1.0.0")
                .description("Item API 명세서");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}