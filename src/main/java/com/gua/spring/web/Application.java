package com.gua.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 类Application.java的实现描述：localhost:8080
 * 
 * @author liuweicheng 2016年1月29日 下午5:39:45
 */
@SpringBootApplication // 等同于 @Configuration @EnableAutoConfiguration @ComponentScan
@ImportResource({"service-beans.xml"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
