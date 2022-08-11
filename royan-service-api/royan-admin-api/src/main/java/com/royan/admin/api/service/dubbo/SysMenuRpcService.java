package com.royan.admin.api.service.dubbo;

import com.royan.admin.api.pojo.bo.SysMenuBO;
import com.royan.admin.api.pojo.vo.SysMenuVO;

import java.util.List;

/**
 * 用户信息表(SysMenu)表服务接口
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
public interface SysMenuRpcService {
	
	/**
	 * 所有菜单树
	 *
	 * @param sysMenuBO
	 * @return
	 */
	List<SysMenuVO> selectMenuTreeAll(SysMenuBO sysMenuBO);
}