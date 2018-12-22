package com.god.common.bean;

import java.util.Map;

/**
 * 分页请求
 * 
 * @author H__D
 * @date 2018-11-15 00:40:43
 *
 */
public class PageRequest {

	private static final Integer DEFAULT_PAGE_CURRENT = 1;
	private static final Integer DEFAULT_PAGE_SIZE = 20;

	/**
	 * 当前页号
	 */
	private int pageNo = DEFAULT_PAGE_CURRENT;
	/**
	 * 页尺寸(大小)
	 */
	private int pageSize = DEFAULT_PAGE_SIZE;

	/**
	 * 排序规则
	 */
	private Map<String, String> sortRules;

	public PageRequest() {
	}

	public PageRequest(int pageNumber, int pageSize) {
		this.pageNo = pageNumber;
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo <= 0 ? DEFAULT_PAGE_CURRENT : pageNo;
	}

	public void setPageNo(int pageNumber) {
		this.pageNo = pageNumber;
	}

	public int getPageSize() {
		return pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, String> getSortRules() {
		return sortRules;
	}

	public void setSortRules(Map<String, String> sortRules) {
		this.sortRules = sortRules;
	}

}
