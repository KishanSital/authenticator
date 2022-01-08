package com.github.KishanSital.authenticator.annotations;

import java.lang.annotation.*;

@CustomAnnotation({"I'm declaring a service annotation"," "})
@CustomAnnotation("Service annotation can be used on other declarations that adhere to ElementType.TYPE_USE")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
@Inherited
public @interface Service {
    String[] value() default "";
}
