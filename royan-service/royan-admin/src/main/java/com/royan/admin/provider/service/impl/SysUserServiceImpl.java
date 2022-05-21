package com.royan.admin.provider.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.royan.admin.api.pojo.bo.SysUserBO;
import com.royan.admin.api.pojo.vo.SysUserVO;
import com.royan.admin.provider.mapper.SysUserMapper;
import com.royan.admin.provider.model.SysUser;
import com.royan.admin.provider.service.SysUserService;
import com.royan.framework.api.model.Pagination;
import com.royan.framework.redis.annotation.RedisLock;
import com.royan.framework.redis.annotation.ReqParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 用户信息表(SysUser)表服务实现类
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
@Slf4j
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    @Override
    @DS("slave")
    public SysUserVO getUserByUsername(String username) {
        if (StrUtil.isEmpty(username)){
            return null;
        }
        //SysUser sysUser = getBaseMapper().getUserByUsername(username);

        SysUserVO sysUserVO = new SysUserVO();
        SysUser sysUser = getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUserName, username));

        if (Objects.isNull(sysUser)) {
            return sysUserVO;
        }

        BeanUtil.copyProperties(sysUser, sysUserVO);
        return sysUserVO;
    }

    @Override
    public Pagination<SysUserVO> search(SysUserBO sysUserBO) {

        log.info("----------------分页查询-----------------");
        Page<SysUser> page = new Page<>(1, 200);
        //page.setOrders(sysUserBO.getOrderByClauses());
        Page<SysUser> userIPage = getBaseMapper().selectPage(
                page, Wrappers.<SysUser>lambdaQuery().like(SysUser::getUserName, "Van")
        );
        log.error("总条数 -------------> {}", userIPage.getTotal());
        log.error("当前页数 -------------> {}", userIPage.getCurrent());
        log.error("当前每页显示数 -------------> {}", userIPage.getSize());

        Pagination<SysUserVO> pagination = Pagination.getInstance(1, 200);
        pagination.setRowTotal(userIPage.getTotal());
        pagination.setPageTotal(userIPage.getTotal());
//        pagination.setRows(userIPage.getRecords());
        return pagination;
    }

    @Override
    @RedisLock(prefix = "add:user", expire = 10, timeUnit = TimeUnit.SECONDS)
    public Integer saveSysUser(@ReqParams(name = "userBO") SysUserBO sysUserBO) {
        return null;
    }
}
