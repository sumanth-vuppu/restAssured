package org.oauth2.tests.utils;

import com.github.javafaker.Faker;

public class FakeUtils {
    public static String generateName(){
        Faker faker=new Faker();
      return   faker.regexify("[A-Za-z0-9_#]{20}");

    }}


