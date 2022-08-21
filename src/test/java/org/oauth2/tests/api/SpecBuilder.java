package org.oauth2.tests.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.oauth2.tests.api.Route.BASEPATH;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec(){
        return  new RequestSpecBuilder()
                .setBaseUri("https://api.spotify.com")
                .setBasePath(BASEPATH)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())

                .log(LogDetail.ALL).build();

    }
public static RequestSpecification getAccountRequestSpec(){

    return  new RequestSpecBuilder()
            .setBaseUri("https://accounts.spotify.com")
            .addFilter(new AllureRestAssured())
           // .setBaseUri(System.getProperty("baseuri"))
            .setContentType(ContentType.URLENC).build();

}
    public static ResponseSpecification getResponseSpec(){

       return new ResponseSpecBuilder()

                .log(LogDetail.ALL).build();
    }
}
