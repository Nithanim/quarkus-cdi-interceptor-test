package org.acme;

import javax.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class ServiceA {
    @MyInterceptorAnnotation
    public void doWork() {
        log.info("Just the class, no interface. Included by annotation.");
    }
}
