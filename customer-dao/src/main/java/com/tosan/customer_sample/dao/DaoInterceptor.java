package com.tosan.customer_sample.dao;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.tosan.customer_sample.logger.log4j.CustomerLogger;
import org.apache.logging.log4j.Logger;

public class DaoInterceptor {

    private static Logger logger = CustomerLogger.logger(DaoInterceptor.class);

    @AroundInvoke
    public Object methodInterceptor(InvocationContext context) throws Exception {
        logger.info(String.valueOf(calledSignature(context)));

        Object proceed = null;
        try {
            proceed = context.proceed();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return proceed;
    }

    private StringBuilder calledSignature(InvocationContext ctx) {
        StringBuilder called = new StringBuilder();
        List<String> params = Arrays.stream(ctx.getParameters()).map(String::valueOf).collect(Collectors.toList());
        called.append(ctx.getTarget().getClass().getPackage().getName()
                + "." + ctx.getTarget().getClass().getName()
                + "." + ctx.getMethod().getName() + "(");
        called.append(String.join(",", params));
        called.append(")");
        return called;
    }

}
