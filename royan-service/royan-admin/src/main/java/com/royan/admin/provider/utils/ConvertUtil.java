package com.royan.admin.provider.utils;

import cn.hutool.core.collection.CollectionUtil;
import com.royan.admin.api.pojo.vo.SysUserVO;
import com.royan.admin.provider.model.SysUser;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @author Qiurz
 * @version 1.0
 * @project royan-platform
 * @description
 * @date 2022/5/22 09:05:56
 */
public class ConvertUtil {

    /**
     * 转换bean
     *
     * @param sysUsers
     * @return
     */
    public static List<SysUserVO> convertBean(List<SysUser> sysUsers) {
        List<SysUserVO> list = Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(sysUsers)) {
            for (SysUser user : sysUsers) {
                list.add(new SysUserVO().setSysUserVO(user));
            }
        }
        return list;
    }
}
