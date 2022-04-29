package com.royan.framework.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * 分页通用实体
 *
 * @author Qiurz
 * <p>
 * 8
 */
public class Pagination<T> {

    private List<T> rows;
    private long page;
    private long pageSize;
    private long rowTotal;
    private long pageTotal;
    private boolean count;
    @JsonIgnore
    private GenericBO criteria;
    private List<Aggregation> aggregations;

    public Pagination() {
        this(1, 10, true);
    }

    public static Pagination.PaginationBuilder newBuilder() {
        return new Pagination.PaginationBuilder();
    }

    public Pagination(int page, int pageSize, boolean count) {
        this.rows = null;
        this.rowTotal = 0;
        this.pageTotal = 0;
        this.count = true;
        this.setPage(page);
        this.setPageSize(pageSize);
        this.count = count;
    }

    public static Pagination getInstance(int page, int pageSize) {
        return new Pagination(page, pageSize, true);
    }

    public static Pagination getInstance2Top(int top) {
        return new Pagination(0, top, false);
    }

    public static Pagination getInstance4BO(GenericBO genericBO) {
        Pagination pagination = new Pagination(genericBO.getPage(), genericBO.getPageSize(), true);
        pagination.setCriteria(genericBO);
        return pagination;
    }

    public static Pagination getInstance2Top4BO(GenericBO genericBO) {
        Pagination pagination = new Pagination(0, genericBO.getPageSize(), false);
        pagination.setCriteria(genericBO);
        return pagination;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getRowTotal() {
        return this.rowTotal;
    }

    public void setRowTotal(long rowTotal) {
        this.rowTotal = rowTotal;
    }

    public long getPageTotal() {
        return this.pageTotal;
    }

    public void setPageTotal(long pageTotal) {
        this.pageTotal = pageTotal;
    }

    public boolean isCount() {
        return this.count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public GenericBO getCriteria() {
        return this.criteria;
    }

    public void setCriteria(GenericBO criteria) {
        this.criteria = criteria;
    }

    public List<Aggregation> getAggregations() {
        return this.aggregations;
    }

    public void setAggregations(List<Aggregation> aggregations) {
        this.aggregations = aggregations;
    }

    public static class PaginationBuilder {
        private int page = 0;
        private int pageSize;
        private boolean count;
        private GenericBO criteria;
        private List<Aggregation> aggregations;

        public PaginationBuilder() {
            this.pageSize = 10;
            this.count = true;
        }

        public Pagination.PaginationBuilder queryPage(int page, int pageSize) {
            if (page >= 0 && pageSize >= 1) {
                this.page = page;
                this.pageSize = pageSize;
                return this;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public Pagination.PaginationBuilder count() {
            this.count = true;
            return this;
        }

        public Pagination.PaginationBuilder notCount() {
            this.count = false;
            return this;
        }

        public Pagination.PaginationBuilder withCriteria(GenericBO criteria) {
            this.criteria = criteria;
            return this;
        }

        public Pagination.PaginationBuilder withAggregations(List<Aggregation> list) {
            this.aggregations = list;
            return this;
        }

        public Pagination build() {
            Pagination pagination = new Pagination();
            pagination.setPage(this.page);
            pagination.setPageSize(this.pageSize);
            pagination.setCount(this.count);
            pagination.setCriteria(this.criteria);
            pagination.setAggregations(this.aggregations);
            return pagination;
        }
    }

}
