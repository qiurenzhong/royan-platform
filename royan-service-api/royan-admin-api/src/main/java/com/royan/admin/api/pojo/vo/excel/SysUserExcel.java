package com.royan.admin.api.pojo.vo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class SysUserExcel {

    /**
     * 用户名
     */
    @ExcelProperty("用户名")
    private String username;
    /**
     * 昵称
     */
    @ExcelProperty("昵称")
    private String nickname;
    /**
     * 性别
     */
    @ExcelProperty("性别")
    private Integer gender;
}
