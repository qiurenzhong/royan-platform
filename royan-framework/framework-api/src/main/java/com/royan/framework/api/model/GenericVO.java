package com.royan.framework.api.model;

import com.royan.framework.api.annotaion.JsonDateFormat;
import com.royan.framework.api.annotaion.JsonIdFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Qiurz
 * @date 2021/4/18
 */
@Data
public class GenericVO<K> {

    private static final long serialVersionUID = 1L;
    protected K id;
    @JsonIdFormat
    protected String createBy;
    @JsonDateFormat("yyyy-MM-dd HH:mm:ss")
    protected Timestamp createTime;
    @JsonIdFormat
    protected String updateBy;
    @JsonDateFormat("yyyy-MM-dd HH:mm:ss")
    protected Timestamp updateTime;
    protected Long enabledFlag;
    protected String traceId;
}
