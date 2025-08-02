package com.product.management.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public OpenAPI productPocOenAPI(){
        return new OpenAPI()
                .info(new Info()
                .title("MongoDB Product POC API")
                .description("SpringBoot MongoDB POC")
                .version("v1.0").license(new License().name("Apache 2.0").url("http://springdoc.org")))
                                .externalDocs(new ExternalDocumentation().description("Github Repository").url("https://github.com/PoojaGupta83/MongoDB-ProductPOC"));
    }
}
