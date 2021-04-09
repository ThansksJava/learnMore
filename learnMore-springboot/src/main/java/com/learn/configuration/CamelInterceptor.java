package com.learn.configuration;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author oule@didiglobal.com
 * @description CamelIntercepter
 * @createtime 2021/4/7
 */
@Component
@Intercepts({
        @Signature(type = Executor.class,method = "query",args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class CamelInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement statements = (MappedStatement)args[0];
        Configuration configuration = statements.getConfiguration();
        configuration.setMapUnderscoreToCamelCase(false);
        Class<?> classType = Class.forName(statements.getId().substring(0, statements.getId().lastIndexOf(".")));
        if(classType.isAnnotationPresent(CamelAllow.class)){
            configuration.setMapUnderscoreToCamelCase(true);
        }
        return invocation.proceed();


    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
