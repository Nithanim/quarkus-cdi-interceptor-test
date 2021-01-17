package org.acme;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Interceptor
@MyInterceptorAnnotation
public class MyInterceptor {
    @AroundInvoke
    Object logInvocation(InvocationContext context) throws Exception {
        log.info("INTERCEPTOR {}", context.getMethod().getDeclaringClass().getSimpleName());
        return context.proceed();
    }
}
