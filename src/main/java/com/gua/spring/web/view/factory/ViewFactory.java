package com.gua.spring.web.view.factory;

import com.gua.open.connection.result.CommunicateResult;

/**
 * 类ViewFactory.java的实现描述：TODO 类实现描述 
 * @author weicheng.lwc 2017年3月30日 上午10:55:18
 */
public interface ViewFactory<T> {
    
    public T getView(CommunicateResult result);
}
