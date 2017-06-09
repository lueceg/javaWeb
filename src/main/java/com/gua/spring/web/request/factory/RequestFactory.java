package com.gua.spring.web.request.factory;

import javax.servlet.http.HttpServletRequest;

import com.gua.spring.web.request.Request;

/**
 * 类RequestFactory.java的实现描述：TODO 类实现描述 
 * @author weicheng.lwc 2017年3月30日 上午10:34:16
 */
public interface RequestFactory<T extends Request> {
    
    public T create(HttpServletRequest request);
}
