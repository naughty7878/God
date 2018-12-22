package com.god.common.bean;

import java.util.ArrayList;
import java.util.List;
/**
 * 分页请求结果
 * @author H__D
 * @date 2018-11-15 00:50:17
 *
 * @param <T>
 */
public class PageResult<T> {

    public PageResult() {

    }
    /**
     * 返回的数据结果集
     */
    private List<T> resultList;
    /**
     * 总记录数
     */
    private Integer totalRecord;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 当前页
     */
    private Integer pageNo;
    /**
     * 页尺寸
     */
    private Integer pageSize;
    
    public PageResult(Integer totalRecord, Integer pageNo, Integer pageSize) {
        this.resultList = new ArrayList<T>();
        this.totalRecord = totalRecord;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = (totalRecord % pageSize == 0 ? totalRecord/pageSize : (totalRecord/pageSize + 1));
    }

    public PageResult(List<T> resultList, Integer totalRecord, Integer pageNo, Integer pageSize) {
        this.resultList = resultList;
        this.totalRecord = totalRecord;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = (totalRecord % pageSize == 0 ? totalRecord/pageSize : (totalRecord/pageSize + 1));
    }

    public PageResult(List<T> resultList, Integer totalRecord, Integer totalPage, Integer pageNo, Integer pageSize) {
        this.resultList = resultList;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNumber(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
