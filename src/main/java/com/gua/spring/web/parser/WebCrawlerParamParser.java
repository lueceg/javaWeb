package com.gua.spring.web.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gua.open.connection.parameter.RequestParams;
import com.gua.spring.web.builder.WebCrawlerParamBuilder;
import com.gua.spring.web.request.WebCrawlerRequest;

/**
 * 类WebCrawlerParamParser.java的实现描述：TODO 类实现描述 
 * @author weicheng.lwc 2017年3月30日 上午10:08:28
 */
@Service
public class WebCrawlerParamParser implements ParamParser<RequestParams, WebCrawlerRequest> {

    
    @Autowired
    @Qualifier("stockWebCrawlerParamBuilder")
    private WebCrawlerParamBuilder webCrawlerParamBuilder;
    
    @Override
    public RequestParams parse(WebCrawlerRequest request) {
        RequestParams requestParams = new RequestParams();
        webCrawlerParamBuilder.build(requestParams, request);
        return requestParams;
    }


}
