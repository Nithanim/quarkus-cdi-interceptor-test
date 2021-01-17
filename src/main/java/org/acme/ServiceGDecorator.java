package org.acme;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import lombok.extern.slf4j.Slf4j;

@Alternative
@ApplicationScoped
@Priority(1)
@Slf4j
public class ServiceGDecorator implements ServiceG {
    ServiceG delegate;

    /**
     * Must specifically request impl, otherwise would recursively inject itself.
     */
    public ServiceGDecorator(ServiceGImpl delegate) {
        this.delegate = delegate;
    }


    @Override
    public void doWork() {
        log.info("DECORATOR HACK!");
        delegate.doWork();
    }
}
