package com.gua.spring.web.view.factory;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gua.open.connection.result.CommunicateResult;
import com.gua.spring.web.parser.StockInfoParser;
import com.gua.spring.web.service.StockExcelStoreService;
import com.gua.spring.web.view.WebCrawlerView;

/**
 * 类WebCrawlerViewFactory.java的实现描述：TODO 类实现描述 
 * @author weicheng.lwc 2017年3月30日 上午10:56:29
 */
@Service
public class WebCrawlerViewFactory implements ViewFactory<WebCrawlerView>{
    
    private final static Logger logger = LoggerFactory.getLogger(WebCrawlerViewFactory.class);
    
    @Autowired
    private StockInfoParser stockInfoParser;
    
    @Autowired
    @Qualifier("stockExcelStoreService")
    private StockExcelStoreService stockExcelStoreService;

    @Override
    public WebCrawlerView getView(CommunicateResult result) {
        WebCrawlerView view = new WebCrawlerView();
        if (null == result) {
            return view;
        }
        if (StringUtils.isNotBlank(result.getExceptionDescription())) {
            logger.error("Oops!!! Comminucate faild!! " + result.getExceptionDescription());
        }
        String data = result.getData();
        if (StringUtils.isBlank(data)) {
            return view;
        }
        
        Document document = Jsoup.parse(data);
        List<List<String>> stockList = stockInfoParser.parseSimple(document);
        
//        List<List<String>> stockList = stockInfoParser.parseSimple(data);
        
        boolean isStoreSucess = stockExcelStoreService.store(stockList);
        System.out.println(isStoreSucess);
        return view;
    }

}
