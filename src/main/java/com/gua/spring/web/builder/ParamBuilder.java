package com.gua.spring.web.builder;

import com.gua.spring.web.request.Request;

/**
 * 类ParamBuilder.java的实现描述：
 * 
 * @author weicheng.lwc 2017年3月30日 上午10:13:22
 */
public interface ParamBuilder<T, E extends Request> {

    public void build(T params, E request);
}
