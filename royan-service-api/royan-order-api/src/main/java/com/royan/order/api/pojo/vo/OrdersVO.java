package com.royan.order.api.pojo.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * (Orders)表响应请求实体类
 *
 * @author makejava
 * @since 2022-06-05 10:08:28
 */
@Data
@EqualsAndHashCode
public class OrdersVO implements Serializable {
   
       
    private Long id;
	    
    private Integer payAmount;
	    
    private Long productId;
	    
    private Integer status;
	    
    private Long userId;
	
}