package com.demo.springbootsimple.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.demo.springbootsimple.mapper")
@Configuration
public class MyBatisPlusConfig {

}
