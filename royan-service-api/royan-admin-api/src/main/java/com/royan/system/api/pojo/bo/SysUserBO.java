package com.royan.system.api.pojo.bo;

import com.royan.system.api.pojo.vo.SysUserVO;
import com.royan.framework.api.model.GenericBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Qiurz
 * @date 2021/4/18
 */
@Data
@EqualsAndHashCode
public class SysUserBO extends GenericBO<SysUserVO> {


    public SysUserBO() {
        setVo(new SysUserVO());
    }

    private String username;
}
