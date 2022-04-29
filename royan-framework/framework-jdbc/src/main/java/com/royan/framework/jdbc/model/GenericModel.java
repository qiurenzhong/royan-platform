package com.royan.framework.jdbc.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 *  <p>
 *      1.mybatis-plus 逻辑删除注解@TableLogic,逻辑已删除值(默认为 1)，逻辑未删除值(默认为 0)
 *      2.mybatis-plus 自动填充注解@TableField ，如果是父类必须带上FieldStrategy
 *      3.mybatis-plus ID生成器注解@TableId，生成策略：ASSIGN_ID（支持自动转换为String类型），ASSIGN_UUID（默认不含中划线的UUID生成）
 *  </p>
 * @author Qiurz
 */
@Setter
@Getter
public class GenericModel<K> {

    private static final long serialVersionUID = 1L;

    /**
     *  IdType.ASSIGN_ID 自动生成主键ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    protected K id;

    @TableField(fill = FieldFill.INSERT_UPDATE,insertStrategy = FieldStrategy.DEFAULT)
    protected String createBy;

    @TableField(fill = FieldFill.INSERT_UPDATE,insertStrategy = FieldStrategy.DEFAULT)
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected Timestamp createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE,updateStrategy = FieldStrategy.DEFAULT)
    protected String updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE,updateStrategy = FieldStrategy.DEFAULT)
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected Timestamp updateTime;

    @TableLogic
    @TableField(fill = FieldFill.INSERT_UPDATE,updateStrategy = FieldStrategy.DEFAULT)
    protected Long enabledFlag;

    protected String traceId;

}
