package com.gua.spring.web.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gua.open.connection.parameter.RequestParams;
import com.gua.open.connection.result.CommunicateResult;
import com.gua.open.connection.service.HttpCommunicateService;
import com.gua.spring.web.parser.WebCrawlerParamParser;
import com.gua.spring.web.request.WebCrawlerRequest;
import com.gua.spring.web.request.factory.WebCrawlerRequestFactory;
import com.gua.spring.web.view.WebCrawlerView;
import com.gua.spring.web.view.factory.WebCrawlerViewFactory;

/**
 * 类WebDataCrawlerControl.java的实现描述：
 * 
 * @author weicheng.lwc 2017年3月30日 上午10:02:36
 */
@RestController
public class WebDataCrawlerControl {

    @Autowired
    private WebCrawlerRequestFactory webCrawlerRequestFactory;

    @Autowired
    private WebCrawlerParamParser    webCrawlerParamParser;

    @Autowired
    private HttpCommunicateService   httpCommunicateService;

    @Autowired
    private WebCrawlerViewFactory    webCrawlerViewFactory;

    @RequestMapping("/crawler/data")
    public void execute(HttpServletRequest request, Model context) {
        WebCrawlerRequest webCrawlerRequest = webCrawlerRequestFactory.create(request);
        RequestParams requestParams = webCrawlerParamParser.parse(webCrawlerRequest);
        CommunicateResult result = httpCommunicateService.communicate(requestParams);
        WebCrawlerView view = webCrawlerViewFactory.getView(result);

        context.addAttribute("view", view);
    }

}
