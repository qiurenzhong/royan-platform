package com.royan.admin.api.model;

import com.royan.framework.api.model.GenericModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息表(SysUser)实体类
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends GenericModel<Long> {

    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别
     */
    private Integer gender;
    /**
     *
     * 密码
     */
    private String password;
    /**
     * 部门ID
     */
    private Integer deptId;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 联系方式
     */
    private String mobile;
    /**
     * 用户状态（0正常 1禁用）
     */
    private Integer status;
    /**
     * 用户邮箱
     */
    private String email;


}
