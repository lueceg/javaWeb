package com.gua.spring.web.parser;

import java.util.List;

import org.jsoup.nodes.Document;

import com.gua.spring.web.dto.StockInfoDTO;

/**
 * 类StockInfoParser.java的实现描述：TODO 类实现描述 
 * @author weicheng.lwc 2017年4月10日 下午7:36:10
 */
public interface StockInfoParser {
    
    /**
     * 详细解析
     * @param document
     * @return
     */
    public List<StockInfoDTO> parse(Document document);

    /**
     * 简单解析
     * @param document
     * @return
     */
    public List<List<String>> parseSimple(Document document);
    
    /**
     * 简单解析
     * @param data
     * @return
     */
    public List<List<String>> parseSimple(String data);
}
