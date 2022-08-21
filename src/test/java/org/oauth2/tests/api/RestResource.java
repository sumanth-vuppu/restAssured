package org.oauth2.tests.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.oauth2.tests.pojo.Playlist;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.oauth2.tests.api.Route.API;
import static org.oauth2.tests.api.Route.TOKEN;
import static org.oauth2.tests.api.SpecBuilder.*;

public class RestResource {
    //static String accessToken="BQB3NLjIwuO_lOMpgxmDXNwV2XwIAddJhzm-E0Te7dqiJphwjHlUgH2ze-vE-SGi3uzc357cY6OmeU719yomjE4ZMAhcb8qgc19hfgObajFR8IltY1blAUhjELY_SjFoajkXCBn-azpTLSVpOxK4QagDysrkzQXyn4KOD1Ew-LtlizyKyGttNSh-gV_WIYhRTcb9CKwtlJfnIlw6wZVoZBmMeLXYGnn-jaIxdRycfbNHB3GgP2MrTZVBPGDRdpjHfN9DMJQwxi4CGrRh";
    public static Response post(Playlist playlist,String accessToken,String path){
       return     given(getRequestSpec())
               .auth().oauth2(accessToken)

              // .header("Authorization","Bearer "+accessToken)
                .when()
                .body(playlist)
                .post(path)
                .then().
                spec(getResponseSpec()).extract().response();

    }


public static Response get(String accessToken,String path){
    return   given(getRequestSpec()).header("Authorization","Bearer "+accessToken)
            .when()

            .get(path)
            .then().
            spec(getResponseSpec()).extract().response();


}
public static Response postAccount(HashMap<String,String> formParams){
   return given(getAccountRequestSpec())

            .formParams(formParams)
            .when().post(API+TOKEN).then().extract().response();
}

public static Response update(Playlist playlist,String accessToken,String Path){
  return   given(getRequestSpec()).header("Authorization","Bearer "+accessToken)
            .body(playlist)
            .when()
            .put(Path)
            .then().extract().response();
}
}
