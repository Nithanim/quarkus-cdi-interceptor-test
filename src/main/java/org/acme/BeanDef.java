package org.acme;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.interceptor.Interceptors;

@Dependent
public class BeanDef {
    @Produces
    public ServiceB serviceB() {
        return new ServiceB();
    }

    @Produces
    public ServiceD serviceD() {
        return new ServiceDImpl();
    }

    @Produces
    public ServiceE serviceE() {
        return new ServiceEImpl();
    }

    @Produces
    public ServiceFImpl serviceF() {
        return new ServiceFImpl();
    }

    /**
     * Must return the specific implementation! Otherwise decorator won't find it.
     */
    @Produces
    public ServiceGImpl serviceG() {
        return new ServiceGImpl();
    }
}
