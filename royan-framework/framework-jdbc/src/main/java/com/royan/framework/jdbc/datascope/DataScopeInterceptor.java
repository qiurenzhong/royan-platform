package com.royan.framework.jdbc.datascope;

import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.handlers.AbstractSqlParserHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 *   Mybatis 拦截器 主要用于数据权限拦截
 * @author Qiurz
 * @date 2021/4/24
 */
@Slf4j
@Component
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare",args = {Connection.class,Integer.class})})
public class DataScopeInterceptor extends AbstractSqlParserHandler implements Interceptor {

    private DataSource dataSource;


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (log.isInfoEnabled()){
            log.debug("进入 DataScopeInterceptor 数据权限拦截...");
        }

        StatementHandler statementHandler = PluginUtils.realTarget(invocation.getTarget());

        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        this.sqlParser(metaObject);

        // 判断是不是select操作，如不是则直接过
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        if (!SqlCommandType.SELECT.equals(mappedStatement.getSqlCommandType())) {
            return invocation.proceed();
        }


        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        // 执行的sql语句
        String originalSql = boundSql.getSql();
        // sql语句的参数
        Object parameterObject = boundSql.getParameterObject();

        // 查找参数中是否存在dataScope
        DataScope dataScope = findDataScopeObject(parameterObject);
        if (Objects.isNull(dataScope)) {
            return invocation.proceed();
        }




        return invocation.proceed();
    }


    /**
     *  生成拦截对象的代理
     *
     * @param target 目标对象
     * @return 代理对象
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target,this);
        }
        return target;
    }

    /**
     *  mybatis配置的属性
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }

    /**
     *  查找参数是否包括DataScope对象
     *
     * @param parameterObj  参数列表
     * @return
     */
    private DataScope findDataScopeObject(Object parameterObj) {
        if (parameterObj instanceof DataSource) {
            return (DataScope) parameterObj;
        }else if (parameterObj instanceof Map) {
            for (Object val:((Map<?,?>)parameterObj).values()) {
                if (val instanceof DataScope) {
                    return (DataScope) val;
                }
            }
        }

        return null;
    }
}
