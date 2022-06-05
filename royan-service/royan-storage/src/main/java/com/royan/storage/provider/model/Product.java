package com.royan.storage.provider.model;

import com.royan.framework.jdbc.model.GenericModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * (Product)表实体类
 *
 * @author makejava
 * @since 2022-06-05 10:16:39
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends GenericModel<Long> {
    
    private Long id;
    
    private Integer price;
    
    private Integer stock;

}