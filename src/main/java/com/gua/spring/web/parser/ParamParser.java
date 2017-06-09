package com.gua.spring.web.parser;

import com.gua.spring.web.request.Request;

/**
 * 类ParamParser.java的实现描述：
 * 
 * @author weicheng.lwc 2017年3月30日 上午10:09:19
 */
public interface ParamParser<T, E extends Request> {
    
    public T parse(E request);

}
