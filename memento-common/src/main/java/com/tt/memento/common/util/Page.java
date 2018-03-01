package com.tt.memento.common.util;

import java.io.Serializable;

/**
 * date: 2018/3/1
 * author: wt
 */
public class Page<T> implements Serializable {

    private int pageSize = 10;

    private int pageNo = 1;

    private T data;

    private int total = 0;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getOffset() {
        return pageSize * (pageNo - 1);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
