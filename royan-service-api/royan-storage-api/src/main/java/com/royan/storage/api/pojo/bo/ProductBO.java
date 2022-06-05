package com.royan.storage.api.pojo.bo;

import com.royan.storage.api.pojo.vo.ProductVO;
import com.royan.framework.api.model.GenericBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * (Product)请求参数类
 *
 * @author makejava
 * @since 2022-06-05 10:19:22
 */
@Data
@EqualsAndHashCode
public class ProductBO extends GenericBO<ProductVO> {


    public ProductBO() {
        setVo(new ProductVO());
    }
}