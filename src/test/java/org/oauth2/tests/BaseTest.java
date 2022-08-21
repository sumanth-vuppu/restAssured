package org.oauth2.tests;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {
    @BeforeMethod
    public void beforeMethod(Method name){
        System.out.println(name.getName());
        System.out.println("------------------------------"+Thread.currentThread().getId());
    }
}
