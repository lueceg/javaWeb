package com.gua.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类GreetController.java的实现描述：TODO 类实现描述 
 * @author liuweicheng 2016年1月29日 下午5:56:46
 */
@RestController
public class GreetController {

    @Autowired
    private GreetStyleService greetStyleService;
    
    @RequestMapping("/hello")
    public String greeting() {
        return greetStyleService.englishHello();
    }
    
    @RequestMapping("/")
    public String helloing() {
        return "debug";
    }
}
