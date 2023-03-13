package com.tosan.customer_sample.dao;

import com.tosan.customer_sample.logger.CustomerLogger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DaoInterceptor {

    private static Logger logger = (new CustomerLogger()).logger(DaoInterceptor.class.getSimpleName());

    @AroundInvoke
    public Object methodInterceptor(InvocationContext context) throws Exception {
        logger.info(String.valueOf(calledSignature(context)));



        return context.proceed();
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
