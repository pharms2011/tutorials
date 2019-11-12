package com.inertia.annotations.classes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestClassAnnotation {

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    Priority priority() default Priority.MEDIUM;

    String[] tags() default "";

    String createdBy() default "Preston Harms";

}
