package com.royan.storage.provider.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Storage extends GenericModel<Long> {
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;

}