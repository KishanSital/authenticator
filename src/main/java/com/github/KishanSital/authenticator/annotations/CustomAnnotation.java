package com.github.KishanSital.authenticator.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Repeatable(CustomAnnotations.class)
@Target(ElementType.ANNOTATION_TYPE)
public @interface CustomAnnotation {
String[] value() default "Annotation created by me to apply to other custom annotations which are also created by me";
}
