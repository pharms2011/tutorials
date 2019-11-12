package com.inertia.implemenation;

import com.inertia.annotations.classes.TestClassAnnotation;
import com.inertia.annotations.fields.TestFieldAnnotation;
import com.inertia.annotations.method.TestMethodAnnotation;

@TestClassAnnotation
public class TestImpl {

    @TestFieldAnnotation
    public int testInt;

    @TestFieldAnnotation
    public boolean testBool;

    @TestMethodAnnotation
    public String testMethod(){
        return "Test Impl";
    }

}
