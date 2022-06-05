package com.royan.account.api.pojo.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * (Account)表响应请求实体类
 *
 * @author makejava
 * @since 2022-06-05 09:30:09
 */
@Data
@EqualsAndHashCode
public class AccountVO implements Serializable {
   
       
    private Long id;
	    
    private Integer balance;
	
}