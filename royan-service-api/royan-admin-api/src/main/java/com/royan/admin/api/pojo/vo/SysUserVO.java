package com.royan.admin.api.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Qiurz
 * @date 2021/4/18
 */
@Data
@EqualsAndHashCode
public class SysUserVO implements Serializable {
    /**
     *  主键ID
     */
    private Long id;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 用户账号
     */
    private String userName;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户类型（00系统用户）
     */
    private String userType;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phonenumber;
    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 密码
     */
    private String password;
    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;
    /**
     * 最后登录IP
     */
    private String loginIp;
    /**
     * 最后登录时间
     */
    private Date loginDate;
    /**
     * 备注
     */
    private String remark;

    public <T> SysUserVO setSysUserVO(T obj) {
        Mapper mapper = new DozerBeanMapper();
        return mapper.map(obj, SysUserVO.class);
    }
}
