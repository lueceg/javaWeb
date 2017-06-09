package com.gua.spring.web.service;

import java.util.List;

/**
 * 类StoreService.java的实现描述：TODO 类实现描述 
 * @author weicheng.lwc 2017年4月10日 下午7:52:15
 */
public interface StoreService<T> {
    
    public boolean store(List<T> dataList);
}
