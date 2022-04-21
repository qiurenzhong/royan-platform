package com.royan.framework.api.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Qiurz
 * @date 2021/4/18
 */
@Setter
@Getter
public class Aggregation {

    public static String AGGRS_TYPE_METRICS_STAT = "stat";
    public static String AGGRS_TYPE_METRICS_SUM = "sum";
    public static String AGGRS_TYPE_METRICS_AVG = "avg";
    public static String AGGRS_TYPE_METRICS_MAX = "max";
    public static String AGGRS_TYPE_METRICS_MIN = "min";
    public static String AGGRS_TYPE_METRICS_COUNT = "count";
    public static String AGGRS_TYPE_BUCKET_TERMS = "terms";
    private String operation;
    private String field;
    private String resultKey;
    private Object resultVal;
}
