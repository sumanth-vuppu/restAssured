package org.oauth2.tests.api.apiApplication;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.oauth2.tests.api.RestResource;
import org.oauth2.tests.pojo.Playlist;

import static io.restassured.RestAssured.given;
import static org.oauth2.tests.api.RenewToken.getToken;
import static org.oauth2.tests.api.Route.PLAYLISTS;
import static org.oauth2.tests.api.Route.USERS;
import static org.oauth2.tests.api.SpecBuilder.getRequestSpec;
import static org.oauth2.tests.api.SpecBuilder.getResponseSpec;

public class PlaylistApi {
    //static String accessToken="BQB3NLjIwuO_lOMpgxmDXNwV2XwIAddJhzm-E0Te7dqiJphwjHlUgH2ze-vE-SGi3uzc357cY6OmeU719yomjE4ZMAhcb8qgc19hfgObajFR8IltY1blAUhjELY_SjFoajkXCBn-azpTLSVpOxK4QagDysrkzQXyn4KOD1Ew-LtlizyKyGttNSh-gV_WIYhRTcb9CKwtlJfnIlw6wZVoZBmMeLXYGnn-jaIxdRycfbNHB3GgP2MrTZVBPGDRdpjHfN9DMJQwxi4CGrRh";
    @Step
    public static Response post(Playlist playlist){
       return RestResource.post(playlist,getToken(),USERS+"/31vwmbqo6rzsrak5et77c6t2qema"+PLAYLISTS);
           /*    given(getRequestSpec())
               .header("Authorization","Bearer "+accessToken)
                .when()
                .body(playlist)
                .post("/users/31vwmbqo6rzsrak5et77c6t2qema/playlists")
                .then().
                spec(getResponseSpec()).extract().response();*/

    }
    public static Response post(String token,Playlist playlist){
        return  RestResource.post(playlist,token,USERS+"/31vwmbqo6rzsrak5et77c6t2qema"+PLAYLISTS);
             /*   given(getRequestSpec())

                .header("Authorization","Bearer "+token)

                .when()
                .body(playlist)
                .post("/users/31vwmbqo6rzsrak5et77c6t2qema/playlists")
                .then().
                spec(getResponseSpec()).extract().response();*/

    }

public static Response get(String playlistID){
    return  RestResource.get(getToken(),PLAYLISTS+"/"+playlistID) ;
        /*    given(getRequestSpec()).header("Authorization","Bearer "+accessToken)
            .when()

            .get("/playlists/10TnV7njR5xZ5HZoGYxzLV")
            .then().
            spec(getResponseSpec()).extract().response();*/


}

public static Response update(Playlist playlist,String playlistId){
  return  RestResource.update(playlist,getToken(),PLAYLISTS+"/"+playlistId) ;
         /* given(getRequestSpec()).header("Authorization","Bearer "+accessToken)
            .body(playlist)
            .when()
            .put("playlists/10TnV7njR5xZ5HZoGYxzLV")
            .then().extract().response();*/
}
}
