package com.gua.spring.web.request.factory;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gua.spring.web.request.WebCrawlerRequest;

/**
 * 类WebCrawlerRequestFactory.java的实现描述：
 * 
 * @author weicheng.lwc 2017年3月30日 上午10:35:58
 */
@Service
public class WebCrawlerRequestFactory implements RequestFactory<WebCrawlerRequest> {

    private final static Logger logger = LoggerFactory.getLogger(WebCrawlerRequestFactory.class);

    @Override
    public WebCrawlerRequest create(HttpServletRequest request) {
        WebCrawlerRequest webCrawlerRequest = new WebCrawlerRequest();
        webCrawlerRequest.setPage(getIntegerParam(request, "p"));

        return webCrawlerRequest;
    }

    private Integer getIntegerParam(HttpServletRequest request, String paramName) {
        Integer integerParam = Integer.valueOf(0);

        String param = request.getParameter(paramName);
        if (StringUtils.isBlank(param)) {
            return integerParam;
        }

        try {
            integerParam = Integer.parseInt(param);
        } catch (NumberFormatException e) {
            StringBuilder builder = new StringBuilder();
            builder.append("can't parse to int, param name is ").append(paramName).append(",").append("value is ").append(param);
            logger.error(builder.toString(), e);
        }
        return integerParam;
    }

}
