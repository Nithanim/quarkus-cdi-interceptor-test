package org.acme;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceEImpl implements ServiceE {
    @Override
    public void doWork() {
        log.info("Interface and impl. Included via @Produces as interface. Interceptor annotation on interface.");
    }
}
