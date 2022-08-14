package com.royan.system.provider.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.royan.framework.jdbc.model.GenericModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色信息表(SysRole)表实体类
 *
 * @author makejava
 * @since 2022-05-21 10:54:35
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
public class SysRole extends GenericModel<Long> {
	/** 角色名称 */
	private String roleName;
	/** 角色权限字符串 */
	private String roleKey;
	/** 显示顺序 */
	private Integer roleSort;
	/** 数据范围（1：全部数据权限;2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限） */
	private Integer dataScope;
	/** 菜单树选择项是否关联显示 */
	private Integer menuCheckStrictly;
	/** 部门树选择项是否关联显示 */
	private Integer deptCheckStrictly;
	/** 角色状态（0正常;1停用） */
	private Integer status;
	/** 备注 */
	private String remark;
	
}