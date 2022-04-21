package com.royan.framework.jdbc.mybatis;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

/**
 *  分布式ID生成工具
 * @author Qiurz
 * @date 2021/5/15 16:55
 */
public class IdGenClient {

    /**
     *  用mybatis-plus生成Long ID
     * @return
     */
    public static Long getId(){
        IdentifierGenerator identifierGenerator = new DefaultIdentifierGenerator();
        Number id = identifierGenerator.nextId(new Object());
        return Convert.toLong(id);
    }
}
