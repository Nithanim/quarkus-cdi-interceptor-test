# Quarkus CDI Interceptor and Decorator Test

This project is a demonstration of what works and what doesn't in terms of interceptors and decorators. Hint: Decorators explicitly don't work as stated in the documentation but we can fake it.

Our goal is to include a service in the dependency injection container for which we can intercept the method calls. It is exactly the opposite of obvious how to do that, when you do not control the source code of the service.

Each service in this example prints how it is included in the DI. **If** the interceptor is successfully called, it prints for which service it is called before the actual invocation of the service.

The output at time of writing is:
```
2021-01-17 16:56:51,730 INFO  [org.acm.MyInterceptor] (Quarkus Main Thread) INTERCEPTOR ServiceA
2021-01-17 16:56:51,730 INFO  [org.acm.ServiceA] (Quarkus Main Thread) Just the class, no interface. Included by annotation.
2021-01-17 16:56:51,730 INFO  [org.acm.ServiceB] (Quarkus Main Thread) Just the class, no interface. Included via @Produces.
2021-01-17 16:56:51,730 INFO  [org.acm.MyInterceptor] (Quarkus Main Thread) INTERCEPTOR ServiceCImpl
2021-01-17 16:56:51,730 INFO  [org.acm.ServiceCImpl] (Quarkus Main Thread) Interface and impl. Included via annotation. Interceptor annotation on impl.
2021-01-17 16:56:51,730 INFO  [org.acm.ServiceDImpl] (Quarkus Main Thread) Interface and impl. Included via @Produces as interface. Interceptor annotation on impl.
2021-01-17 16:56:51,730 INFO  [org.acm.ServiceEImpl] (Quarkus Main Thread) Interface and impl. Included via @Produces as interface. Interceptor annotation on interface.
2021-01-17 16:56:51,730 INFO  [org.acm.ServiceFImpl] (Quarkus Main Thread) Interface and impl. Included via @Produces as impl. Interceptor annotation on interface.
2021-01-17 16:56:51,731 INFO  [org.acm.ServiceGDecorator] (Quarkus Main Thread) DECORATOR HACK!
2021-01-17 16:56:51,731 INFO  [org.acm.ServiceGImpl] (Quarkus Main Thread) Interface and impl. Included via @Produces as impl. Decorated via @Alternative hack.
```

For most services the interceptor is never called which I (personally) hate it very much and find it not exactly logical.

The decorator hack (`ServiceG`) is a special one because it does not use the intended interceptor.
By an interesting use of `@Alternative` and definition of `@Produces`, `@Alternative` is misused als a decorator that can be used as an interceptor.


Here is the remaining part of the originally readme generated from the codegen if you need it:

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `code-with-quarkus-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/code-with-quarkus-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.
