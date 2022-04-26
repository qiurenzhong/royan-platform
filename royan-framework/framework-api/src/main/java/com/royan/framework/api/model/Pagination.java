package com.royan.framework.api.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 分页通用实体
 *
 * @author Qiurz
 * <p>
 * 8
 */
public class Pagination<T> extends Page<T> {


    public Pagination(int page, int pageSize) {
        super(page, pageSize);
    }
}