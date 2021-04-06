package com.learn.configuration;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author fengjie
 * @version 1.0
 * @date 2021/4/6
 */
@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args={Statement.class})
})
@Component
public class ResultInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        // ResultSetHandler resultSetHandler1 = (ResultSetHandler) invocation.getTarget();
        //通过java反射获得mappedStatement属性值
        //可以获得mybatis里的resultype
        Object result = invocation.proceed();
        if (result instanceof ArrayList) {
            ArrayList resultList = (ArrayList) result;
            for (int i = 0; i < resultList.size(); i++) {
                Object oi = resultList.get(i);
                Class c = oi.getClass();
                Class[] types = {String.class};
                Method method = c.getMethod("setAddress", types);
                // 调用obj对象的 method 方法
                method.invoke(oi, "china");
            }
        }
        return result;
    }

    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    public void setProperties(Properties properties) {
        try {
            Class<?> className = Class.forName(properties.getProperty("className"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
