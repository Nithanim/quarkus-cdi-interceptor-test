package org.acme;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@QuarkusMain
public class HelloWorldMain implements QuarkusApplication {
    @Inject
    ServiceA serviceA;
    @Inject
    ServiceB serviceB;
    @Inject
    ServiceC serviceC;
    @Inject
    ServiceD serviceD;
    @Inject
    ServiceE serviceE;
    @Inject
    ServiceF serviceF;
    @Inject
    ServiceG serviceG;

    @Override
    public int run(String... args) throws Exception {
        serviceA.doWork();
        serviceB.doWork();
        serviceC.doWork();
        serviceD.doWork();
        serviceE.doWork();
        serviceF.doWork();
        serviceG.doWork();
        return 0;
    }
}
