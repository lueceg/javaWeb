package com.gua.spring.web.request;

/**
 * 类WebCrawlerRequest.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年3月30日 上午10:07:00
 */
public class WebCrawlerRequest implements Request {

    /**
     * 页码
     */
    private Integer page;

    /**
     * 额外参数
     */
    private String  extraParams;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(String extraParams) {
        this.extraParams = extraParams;
    }

}
