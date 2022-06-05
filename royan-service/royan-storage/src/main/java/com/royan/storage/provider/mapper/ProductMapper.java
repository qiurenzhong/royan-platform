package com.royan.storage.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.royan.storage.provider.model.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Product)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-05 10:16:38
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

   
}