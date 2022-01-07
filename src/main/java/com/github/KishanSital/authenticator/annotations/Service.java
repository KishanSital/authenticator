package com.github.KishanSital.authenticator.annotations;

import java.lang.annotation.*;

@CustomAnnotation ({"I'm declaring a service annotation"," "})
@CustomAnnotation("Service annotation can be used on other declarations that adhere to ElementType.TYPE_USE")
@Target(ElementType.TYPE) /* the @Service annotation can be used
for classes, enums, annotation and interfaces.*/
@Retention(RetentionPolicy.CLASS) // stored in class but not available at runtime
@Inherited // My @Service annotation will be applied to classes, subclasses will inherit from (providing annotation information)
public @interface Service {
    String[] value() default "";
}
