package org.acme;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceDImpl implements ServiceD {
    @MyInterceptorAnnotation
    @Override
    public void doWork() {
        log.info("Interface and impl. Included via @Produces as interface. Interceptor annotation on impl.");
    }
}
