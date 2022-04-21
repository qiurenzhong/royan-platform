package com.royan.admin.api.pojo.bo;

import com.royan.admin.api.pojo.vo.SysUserVO;
import com.royan.framework.api.model.GenericBO;
import lombok.Data;

/**
 * @author Qiurz
 * @date 2021/4/18
 */
@Data
public class SysUserBO extends GenericBO<SysUserVO> {


    public SysUserBO() {
        setVo(new SysUserVO());
    }

    private String username;
}
