package com.royan.account.provider.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.royan.framework.jdbc.model.GenericModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * (Account)表实体类
 *
 * @author makejava
 * @since 2022-06-05 02:05:52
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Account extends GenericModel<Long> {

    /**
     * IdType.ASSIGN_ID 自动生成主键ID
     *
     */
    @TableId(type = IdType.AUTO)
    protected Long id;
    private Long userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;

}