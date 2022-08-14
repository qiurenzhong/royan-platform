package com.royan.system.provider.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.royan.system.api.pojo.bo.SysUserBO;
import com.royan.system.api.pojo.vo.SysUserVO;
import com.royan.system.api.service.dubbo.SysUserRpcService;
import com.royan.system.provider.mapper.SysUserMapper;
import com.royan.system.provider.model.SysUser;
import com.royan.framework.api.model.OrderByClause;
import com.royan.framework.api.model.Pagination;
import com.royan.framework.core.utils.BeanCopierUtils;
import com.royan.framework.redis.annotation.RedissonLock;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 用户信息表(SysUser)表服务实现类
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
@Slf4j
@DubboService
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserRpcService {
	
	
	@Override
	@DS("slave") // 查询从库
	public SysUserVO getUserByUsername(String username) {
		if (StrUtil.isEmpty(username)) {
			return null;
		}
		SysUserVO sysUserVO = new SysUserVO();
		SysUser sysUser = this.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUserName, username));
		if (Objects.isNull(sysUser)) {
			return sysUserVO;
		}
		sysUserVO.setId(sysUser.getId());
		return sysUserVO.setSysUserVO(sysUser);
	}
	
	@Override
	public Pagination<SysUserVO> search(SysUserBO sysUserBO) {
		SysUser sysUser = BeanCopierUtils.copy(sysUserBO.getVo(), SysUser.class);
		Integer pageNum = sysUserBO.getPageNum();
		Integer pageSize = sysUserBO.getPageSize();
		Page<SysUser> pageSysUser = new Page<>(pageNum, pageSize);
		List<OrderByClause> orderByClauses = sysUserBO.getOrderByClauses();
		pageSysUser.setOrders(BeanCopierUtils.copyArray(orderByClauses, OrderItem.class));
		Page<SysUser> userIPage = getBaseMapper().selectPage(pageSysUser, Wrappers.lambdaQuery(sysUser));
		Pagination<SysUserVO> pagination = Pagination.getInstance4BO(sysUserBO);
		pagination.setRowTotal(userIPage.getTotal());
		pagination.setPageTotal(userIPage.getPages());
		pagination.setRows(BeanCopierUtils.copyArray(userIPage.getRecords(), SysUserVO.class));
		return pagination;
	}
	
	@Override
	@RedissonLock
	public Integer saveSysUser(SysUserBO sysUserBO) {
		SysUserVO vo = sysUserBO.getVo();
		SysUser sysUser = new SysUser();
		BeanUtil.copyProperties(vo, sysUser);
		try {
			// 模拟业务未处理完成，锁是否会释放
			Thread.sleep(TimeUnit.SECONDS.toMillis(60));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getBaseMapper().insert(sysUser);
	}
	
	@Override
	public Integer updateSysUser(SysUserBO sysUserBO) {
		SysUser sysUser = new SysUser();
		BeanCopierUtils.copy(sysUserBO.getVo(), sysUser);
		return getBaseMapper().updateById(sysUser);
	}
	
	@Override
	public Integer deleteSysUser(SysUserBO sysUserBO) {
		SysUser sysUser = new SysUser();
		BeanCopierUtils.copy(sysUserBO.getVo(), sysUser);
		return getBaseMapper().deleteById(sysUser);
	}
	
	@Override
	public SysUserVO getUserByUserId(String loginId) {
		SysUser sysUser = this.getById(Convert.toLong(loginId));
		return BeanCopierUtils.copy(sysUser,SysUserVO.class);
	}
}
