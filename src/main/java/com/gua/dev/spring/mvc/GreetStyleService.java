/*
 * Copyright 1999-2004 Alibaba.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.gua.dev.spring.mvc;

import org.springframework.stereotype.Service;

/**
 * 类GreetService.java的实现描述：TODO 类实现描述
 * 
 * @author liuweicheng 2016年1月29日 下午5:23:57
 */
@Service
public class GreetStyleService {

    public String chinaHello() {
        return "你好!";
    }
    
    public String englishHello() {
        return "Hello!";
    }

}
