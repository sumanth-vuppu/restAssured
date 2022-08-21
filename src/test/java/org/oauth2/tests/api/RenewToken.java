package org.oauth2.tests.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.oauth2.tests.api.RestResource.postAccount;

public class RenewToken {
   public static String accessToken;
  public   static Instant expiryTime;
    public synchronized static String getToken(){
        if(accessToken==null ||Instant.now().isAfter(expiryTime) ){
            Response response=renewToken();
            if(response.statusCode()!=200){
                new RuntimeException("Error response code");
            }
            accessToken=  response.path("access_token");
            int expiryDuration= response.path("expires_in");
            expiryTime=Instant.now().plusSeconds(expiryDuration);
            System.out.println("Renewed new token");
        }else {
            System.out.println("Already token renewed");
        }


return  accessToken;

    }

    private static Response renewToken(){
        HashMap<String,String> formParams=new HashMap<>();
        formParams.put("client_id","271ecaacd63a4a0fbf3a2c091efccba4");
        formParams.put("client_secret","4aba35ff9da1447eb5b88e0ccb2510ac");
        formParams.put("grant_type","refresh_token");
        formParams.put("refresh_token","AQAHGlfvZDfzHU7eeLzI1SI1r1oKpPFypJuNuXFNV9vAt88ZKW1N9ptfX9WaQpcPc992-dIPVcgETUGbz-qJtuQ-LhjfQFSh10d-RKURmXr_QYrE_66-VcOQM9DbmZEaI-I");
       return postAccount(formParams);

    }
}
