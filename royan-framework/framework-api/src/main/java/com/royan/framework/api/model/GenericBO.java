package com.royan.framework.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *  通用的请求参数
 * @author Qiurz
 * @date 2021/4/18
 */
@Setter
@Getter
public class GenericBO<T> {

    private String menuId;
    private String genericSearchCode;
    private String searchCode;
    private T vo;
    private String id;
    private String[] ids;
    private Integer page;
    private Integer pageSize = 10;
    private String elasticsearchFlag = "N";
    private List<OrderByClause> orderByClauses;
    private List<Aggregation> aggregations;
    private String[] includes;
    private String[] excludes;
}
