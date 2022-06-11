package com.royan.storage.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.royan.storage.provider.model.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (Product)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-05 10:16:38
 */
@Mapper
@Repository
public interface StorageMapper extends BaseMapper<Storage> {

    Storage selectByProductId(Long productId);
    int decrease(Storage record);
}