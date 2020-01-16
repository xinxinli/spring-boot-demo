package com.eshore.project.springbootdemo.util;

import java.io.Serializable;

/**
 * 分页查询的基类
 * @author shizan.ge
 */
public class QueryBase implements Serializable{
	private static final long serialVersionUID = -8427614723706645161L;
	private Integer pageSize = 5;  //每页显示条数
	private Integer current = 1;  //当前页码
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		this.current = current;
	}
}
