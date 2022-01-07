package com.github.KishanSital.authenticator.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Repeatable(CustomAnnotations.class) // So i can repeat the usage of CustomAnnotation when declaring other annotations with the @CustomAnnotation
@Target(ElementType.ANNOTATION_TYPE)
public @interface CustomAnnotation { //annotation i created to apply to other annotations
String[] value() default "Annotation created by me to apply to other custom annotations which are also created by me";
}
