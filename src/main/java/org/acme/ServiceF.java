package org.acme;

public interface ServiceF {
    @MyInterceptorAnnotation
    void doWork();
}
