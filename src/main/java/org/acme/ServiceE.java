package org.acme;

public interface ServiceE {
    @MyInterceptorAnnotation
    void doWork();
}
