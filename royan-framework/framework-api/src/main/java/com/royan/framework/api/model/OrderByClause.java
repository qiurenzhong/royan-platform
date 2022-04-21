package com.royan.framework.api.model;

import java.io.Serializable;

/**
 *  排序实体类
 * @author Qiurz
 * @date 2021/4/18
 */
public class OrderByClause implements Serializable {
    private String field;
    private int orderByMode = 0;
    public static final String REGEX = "[\\w|-|_|.]*";

    public OrderByClause() {
    }

    public String getField() {
        return this.field;
    }

    public OrderByClause setField(String field) {
        if (!field.matches(REGEX)) {
            throw new RuntimeException("非法字段，请定义符合的字段！");
        } else {
            this.field = field;
            return this;
        }
    }

    public int getOrderByMode() {
        return this.orderByMode;
    }

    public OrderByClause setOrderByMode(int orderByMode) {
        this.orderByMode = orderByMode;
        return this;
    }
}
