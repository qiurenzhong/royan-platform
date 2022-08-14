package com.royan.system.provider.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.royan.framework.api.model.Pagination;
import com.royan.framework.core.constant.AuthConstants;
import com.royan.system.api.pojo.bo.SysMenuBO;
import com.royan.system.api.pojo.vo.SysMenuVO;
import com.royan.system.api.service.dubbo.SysMenuRpcService;
import com.royan.system.api.service.dubbo.SysRoleRpcService;
import com.royan.system.provider.mapper.SysMenuMapper;
import com.royan.system.provider.model.SysMenu;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 菜单权限表(SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2022-05-21 10:04:01
 */
@Slf4j
@DubboService
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuRpcService {
	
	@DubboReference(check = false)
	private SysRoleRpcService sysRoleRpcService;
	
	@Override
	public Pagination<SysMenuVO> search(SysMenuBO sysMenuBO) {
		return null;
	}
	
	@Override
	public Integer save(SysMenuBO sysMenuBO) {
		return null;
	}
	
	@Override
	public Integer update(SysMenuBO sysMenuBO) {
		return null;
	}
	
	@Override
	public Integer delete(SysMenuBO sysMenuBO) {
		return null;
	}
	
	@Override
	public SysMenuVO get(SysMenuBO sysMenuBO) {
		return null;
	}
	
	@Override
	public List<SysMenuVO> batchGet(SysMenuBO sysMenuBO) {
		return null;
	}
	
	@Override
	public List<SysMenuVO> selectMenuTreeAll(SysMenuBO sysMenuBO) {
		//查询所有的数据
		List<SysMenu> sysMenus = getBaseMapper().selectMenuTreeAll();
		//创建一个list集合，用于存放根节点
		List<SysMenuVO> parentList = new ArrayList<>();
		for (SysMenu sysMenu : sysMenus) {
			//如果parentId为0，则代表是根节点，存入到集合中
			if (sysMenu.getParentId().equals(0L)) {
				parentList.add(new SysMenuVO().setSysUserVO(sysMenu));
			}
		}
		//查找根节点下的子类，因为根节点的id就是 子节点的parentId;
		for (SysMenuVO child : parentList) {
			List<SysMenuVO> children = getChild(child.getId(), sysMenus);
			child.setChildren(children);
		}
		return parentList;
	}
	
	private List<SysMenuVO> getChild(Long id, List<SysMenu> sysMenus) {
		//存放子节点的集合
		List<SysMenuVO> children = new ArrayList<>();
		for (SysMenu sysMenu : sysMenus) {
			//如果根节点的id 等于集合内parentid，说明是根节点的子节点
			if (sysMenu.getParentId().equals(id)) {
				//存入子节点集合
				SysMenuVO sysMenuVO = new SysMenuVO();
				children.add(sysMenuVO.setSysUserVO(sysMenu));
			}
		}
		
		for (SysMenuVO sysMenuVO : children) {
			//递归调用，如果子节点存在根节点，则再次调用，往后依次推
			List<SysMenuVO> personChildren = getChild(sysMenuVO.getId(), sysMenus);
			sysMenuVO.setChildren(personChildren);
			//递归结束条件，如果子节点不存在子节点，则递归结束
			if (children == null) {
				return null;
			}
		}
		return children;
	}
	
	@Override
	public List<String> selectMenuPermsByUserId(Long userId) {
		List<String> perms = new ArrayList<>();
		List<String> roles = sysRoleRpcService.selectRolePermByUserId(userId);
		if (roles.contains(AuthConstants.SYSTEM_ADMIN)) {
			// 管理员拥有所用权限
			perms.add(AuthConstants.ALL_PERMS);
		}else {
			List<String> menuPerms = this.getBaseMapper().selectMenuPermsByUserId(userId);
			if (CollectionUtil.isNotEmpty(menuPerms)) {
				for (String menuPerm : menuPerms) {
					if (StrUtil.isNotBlank(menuPerm)) {
						Collections.addAll(perms,menuPerm);
					}
				}
			}
		}
		return perms;
	}
}