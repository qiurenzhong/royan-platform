package com.royan.admin.provider.model;

import com.royan.framework.jdbc.model.GenericModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 用户信息表(SysUser)实体类
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends GenericModel<Long> {
    //部门ID
    private Long deptId;
    //用户账号
    private String userName;
    //用户昵称
    private String nickName;
    //用户类型（00系统用户）
    private String userType;
    //用户邮箱
    private String email;
    //手机号码
    private String phonenumber;
    //用户性别（0男 1女 2未知）
    private String sex;
    //头像地址
    private String avatar;
    //密码
    private String password;
    //帐号状态（0正常 1停用）
    private String status;
    //最后登录IP
    private String loginIp;
    //最后登录时间
    private Date loginDate;
    //备注
    private String remark;


}
