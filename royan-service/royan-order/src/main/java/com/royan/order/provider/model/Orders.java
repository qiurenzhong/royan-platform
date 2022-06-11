package com.royan.order.provider.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.royan.framework.jdbc.model.GenericModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * (Orders)表实体类
 *
 * @author makejava
 * @since 2022-06-05 10:06:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Orders extends GenericModel<Long> {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;


}