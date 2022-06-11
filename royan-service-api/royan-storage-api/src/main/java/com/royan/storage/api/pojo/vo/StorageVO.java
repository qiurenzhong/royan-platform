package com.royan.storage.api.pojo.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * (Product)表响应请求实体类
 *
 * @author makejava
 * @since 2022-06-05 10:19:23
 */
@Data
@EqualsAndHashCode
public class StorageVO implements Serializable {
   
       
    private Long id;
	    
    private Integer price;
	    
    private Integer stock;
	
}