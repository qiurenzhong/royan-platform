package com.royan.framework.api.model;

import java.io.Serializable;

/**
 *  排序实体类
 * @author Qiurz
 * @date 2021/4/18
 */
public class OrderByClause implements Serializable {
    private String column;
    private boolean asc = true;
    public static final String REGEX = "[\\w|-|_|.]*";

    public OrderByClause() {
    }

    public String getColumn() {
        return this.column;
    }

    public OrderByClause setColumn(String column) {
        if (!column.matches(REGEX)) {
            throw new RuntimeException("非法字段，请定义符合的字段！");
        } else {
            this.column = column;
            return this;
        }
    }

    public boolean getAsc() {
        return this.asc;
    }

    public OrderByClause setOrderByMode(boolean asc) {
        this.asc = asc;
        return this;
    }
}
