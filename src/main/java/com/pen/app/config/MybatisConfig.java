package com.pen.app.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.pen.app.**.mapper")
public class MybatisConfig {

}
