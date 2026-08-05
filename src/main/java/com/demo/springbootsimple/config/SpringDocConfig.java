package com.demo.springbootsimple.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI restfulOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("后台 Swagger API 文档")
                        .description("API 文档，用于指定前后端访问 API 规范，方便测试者对接口进行可视化测试！")
                        .version("v2026")
                        .license(new License().name("").url("")));
    }
}
