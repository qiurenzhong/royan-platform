package com.royan.order.provider.model;

import com.royan.framework.jdbc.model.GenericModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * (Orders)表实体类
 *
 * @author makejava
 * @since 2022-06-05 10:06:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Orders extends GenericModel<Long> {
    
    private Long id;
    
    private Integer payAmount;
    
    private Long productId;
    
    private Integer status;
    
    private Long userId;

}