package com.royan.system.api.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单权限表(SysMenu)表响应请求实体类
 *
 * @author makejava
 * @since 2022-05-21 10:30:36
 */
@Data
@EqualsAndHashCode
public class SysMenuVO implements Serializable {

    //菜单ID
    private Long id;
    //菜单名称
    private String menuName;
    //父菜单ID
    private Long parentId;
    //显示顺序
    private Integer orderNum;
    //路由地址
    private String path;
    //组件路径
    private String component;
    //路由参数
    private String query;
    //是否为外链（0是 1否）
    private Integer isFrame;
    //是否缓存（0缓存 1不缓存）
    private Integer isCache;
    //菜单类型（M目录 C菜单 F按钮）
    private String menuType;
    //菜单状态（0显示 1隐藏）
    private String visible;
    //菜单状态（0正常 1停用）
    private String status;
    //权限标识
    private String perms;
    //菜单图标
    private String icon;
    //创建者
    private String createBy;
    //创建时间
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;
    //子级菜单
    private List<SysMenuVO> children;

    public <T> SysMenuVO setSysUserVO(T obj) {
        Mapper mapper = new DozerBeanMapper();
        return mapper.map(obj, SysMenuVO.class);
    }

}