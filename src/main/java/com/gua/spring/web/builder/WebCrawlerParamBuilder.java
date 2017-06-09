package com.gua.spring.web.builder;

import org.springframework.stereotype.Service;

import com.gua.open.connection.parameter.RequestParams;
import com.gua.spring.web.request.WebCrawlerRequest;

/**
 * 类WebCrawlerParamBuilder.java的实现描述：TODO 类实现描述 
 * @author weicheng.lwc 2017年3月30日 上午10:43:57
 */
@Service
public class WebCrawlerParamBuilder implements ParamBuilder<RequestParams, WebCrawlerRequest>{

    @Override
    public void build(RequestParams params, WebCrawlerRequest request) {
        
    }

}
