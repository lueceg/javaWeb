package com.gua.spring.web.request;

/**
 * 类Request.java的实现描述：
 * 
 * @author weicheng.lwc 2017年3月30日 上午10:06:41
 */
public interface Request {

    public Integer getPage();

    public void setPage(Integer page);

    public String getExtraParams();

    public void setExtraParams(String extraParams);
}
