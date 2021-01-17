package org.acme;

import javax.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class ServiceCImpl implements ServiceC {
    @MyInterceptorAnnotation
    @Override
    public void doWork() {
        log.info("Interface and impl. Included via annotation. Interceptor annotation on impl.");
    }
}
