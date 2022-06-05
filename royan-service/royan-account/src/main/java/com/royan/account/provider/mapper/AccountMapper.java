package com.royan.account.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.royan.account.provider.model.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Account)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-05 02:05:46
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

   
}