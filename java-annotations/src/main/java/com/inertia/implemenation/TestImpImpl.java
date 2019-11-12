package com.inertia.implemenation;

import com.inertia.annotations.classes.TestClassAnnotation;

import java.lang.annotation.Annotation;

public class TestImpImpl {
    public static void main(String[] args) {
        TestImpl impl = new TestImpl();
        impl.testMethod();
        Class c = impl.getClass();
        Annotation an = c.getAnnotation(TestClassAnnotation.class);
        TestClassAnnotation test = (TestClassAnnotation) an;
    }
}
