package org.acme;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceFImpl implements ServiceF {
    @Override
    public void doWork() {
        log.info("Interface and impl. Included via @Produces as impl. Interceptor annotation on interface.");
    }
}
