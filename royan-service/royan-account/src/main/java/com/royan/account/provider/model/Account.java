package com.royan.account.provider.model;

import com.royan.framework.jdbc.model.GenericModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * (Account)表实体类
 *
 * @author makejava
 * @since 2022-06-05 02:05:52
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Account extends GenericModel<Long> {
    
    private Long id;
    
    private Integer balance;

}