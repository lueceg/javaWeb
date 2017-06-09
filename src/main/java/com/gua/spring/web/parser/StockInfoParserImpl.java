package com.gua.spring.web.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gua.spring.web.dto.StockInfoDTO;

/**
 * 类StockInfoParserImpl.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年4月10日 下午7:44:51
 */
@Service("stockInfoParser")
public class StockInfoParserImpl implements StockInfoParser {
    
    private final static String START_MARK = "defjson";
    
    private final static String REGULAR_EXPRESSION = "(?<=defjson:)(.*)]}";

    @Override
    public List<StockInfoDTO> parse(Document document) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<List<String>> parseSimple(Document document) {
        if (null == document) {
            return null;
        }
        
        Elements elements = document.select("script"); // 获取源代码中的所有script元素
        
        String jsonData = StringUtils.EMPTY;
        for (Element element : elements) {
            String html = element.html();
            if (StringUtils.isBlank(html) || !html.contains(START_MARK)) {
                continue;
            }
            
            Pattern pattern = Pattern.compile(REGULAR_EXPRESSION);
            Matcher matcher = pattern.matcher(html);
            while (matcher.find()) {
                jsonData = matcher.group();
            }
            break;
        }
        
        JSONObject parseObject = JSON.parseObject(jsonData);
        JSONArray jsonArray = parseObject.getJSONArray("data");
        
        List<List<String>>  stockList = new ArrayList<List<String>>();
        for (String stock : jsonArray.toJavaList(String.class)) {
            if (StringUtils.isBlank(stock)) {
                continue;
            }
            String[] stockDetails = stock.split(",");
            List<String> stockDetailList = new ArrayList<String>();
            for (String stockDetail : stockDetails) {
                stockDetailList.add(stockDetail);
            }
            stockList.add(stockDetailList);
        }
        
        return stockList;
    }

    @Override
    public List<List<String>> parseSimple(String data) {
        if (null == data) {
            return null;
        }
        
        JSONArray jsonArray = JSON.parseArray(data);
        List<List<String>>  stockList = new ArrayList<List<String>>();
        for (String stock : jsonArray.toJavaList(String.class)) {
            if (StringUtils.isBlank(stock)) {
                continue;
            }
            String[] stockDetails = stock.split(",");
            List<String> stockDetailList = new ArrayList<String>();
            for (String stockDetail : stockDetails) {
                stockDetailList.add(stockDetail);
            }
            stockList.add(stockDetailList);
        }
        
        return stockList;
    }
    
    

}
