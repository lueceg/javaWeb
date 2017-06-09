package com.gua.spring.web.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import com.gua.open.connection.parameter.RequestParams;
import com.gua.spring.web.request.WebCrawlerRequest;

/**
 * 类StockWebCrawlerParamBuilder.java的实现描述：
 * @author weicheng.lwc 2017年4月12日 下午7:56:40
 */
@Service
public class StockWebCrawlerParamBuilder extends WebCrawlerParamBuilder {
    
    private final static String extraParams = "type=NS&sty=NSSTV5&st=12&sr=-1&ps=50&stat=1&rt=49727588";
    
    @Override
    public void build(RequestParams params, WebCrawlerRequest request) {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        if (null != request.getPage() && request.getPage() > 0) {
            NameValuePair nameValuePair = new BasicNameValuePair("p", request.getPage().toString());
            nameValuePairs.add(nameValuePair);
        }
        
        params.setNameValuePairs(nameValuePairs);
        params.setExtraParams(extraParams);
    }

}
