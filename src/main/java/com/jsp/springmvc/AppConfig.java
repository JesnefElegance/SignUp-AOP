package com.jsp.springmvc;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.jsp.springmvc")
@EnableAspectJAutoProxy
public class AppConfig {

}
