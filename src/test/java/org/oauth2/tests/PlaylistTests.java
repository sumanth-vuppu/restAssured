package org.oauth2.tests;

import io.qameta.allure.*;
import io.restassured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.*;
import io.restassured.specification.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import  static  org.oauth2.tests.api.SpecBuilder.*;
import org.hamcrest.MatcherAssert;
import org.oauth2.tests.api.apiApplication.PlaylistApi;
import org.oauth2.tests.api.apiApplication.StatusCodes;
import org.oauth2.tests.pojo.Error;
import org.oauth2.tests.pojo.Playlist;
import org.oauth2.tests.utils.ConfigManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.oauth2.tests.api.apiApplication.PlaylistApi.*;
import static org.oauth2.tests.api.apiApplication.PlaylistApi.post;
@Epic("Spotify oauth2.0")
@Feature("Play list api")
public class PlaylistTests extends BaseTest{
@Story("Create a playlist")
    @Test
    public void shouldAbleToCreateAplaylist(){
        Playlist playlist=playlistBuilder("name1","desc1",false);

        Response response= post(playlist);
        assertStatusCode(response.statusCode(), StatusCodes.CODE_201.code);
        assertEquals(response.as(Playlist.class),playlist);
      /*  String body="{\"name\": \"New Playlist\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": false}";*/

//        Playlist playlist=Playlist.builder()
//                .name("name1").description("desc1")
//                ._public(false).build();



     //  assertThat(response.statusCode(),equalTo(201));
       // Playlist responsePlaylist=    response.as(Playlist.class);


 /*  Playlist responsePlaylist=     given(getRequestSpec())
                .when()
                .body(playlist)
                .post("/users/31vwmbqo6rzsrak5et77c6t2qema/playlists")
                .then().
                spec(getResponseSpec()).
                statusCode(201).extract().as(Playlist.class);*/

//                MatcherAssert.assertThat(responsePlaylist.getName(),equalTo(playlist.getName()));
//        MatcherAssert.assertThat(responsePlaylist.get_public(),equalTo(playlist.get_public()));
//        MatcherAssert.assertThat(responsePlaylist.getDescription(),equalTo(playlist.getDescription()));
              /*  .body("name",equalTo("New Playlist"),
                        "description",equalTo("New playlist description")
                ,"public",equalTo(false)
                );*/
    }

    @Test
    public void shouldAbleToGetPlayList(){
        Response response= PlaylistApi.get(ConfigManager.getInstance().getUserID());
        Playlist playlist=playlistBuilder("Updated New Playlist","Updated New playlist description",false);
        assertStatusCode(response.statusCode(),StatusCodes.CODE_200.code);
        assertEquals(response.as(Playlist.class),playlist);

  /*   Playlist playlist=   given(getRequestSpec())
                .when()

                .get("/playlists/10TnV7njR5xZ5HZoGYxzLV")
                .then().
                spec(getResponseSpec()).
                statusCode(200).extract().as(Playlist.class);*/

    //    Playlist playlist=    response.as(Playlist.class);

//              MatcherAssert.assertThat  (playlist.getName(),equalTo("Updated New Playlist"));
//                 MatcherAssert.assertThat(       playlist.getDescription(),equalTo("Updated New playlist description"));
//                        MatcherAssert.assertThat(playlist.get_public(),equalTo(false)
//                );

    }

    @Link("https://google.com")
    @Link(name="issue link",type = "mylink")
    @Issue("issue")
    @TmsLink("tmslink")
    @Description("description of the method" )
    @Test(description = "adding friendly name")
    public void shouldAbleToUpdatePlayList(){

        Playlist playlist=playlistBuilder("Updated New Playlist","Updated New playlist description",false);
Response response=update(playlist,ConfigManager.getInstance().getUserID());
assertStatusCode(response.statusCode(),StatusCodes.CODE_200.code);

      /*  given(getRequestSpec())
                .body(playlist)
                .when()
                .put("playlists/10TnV7njR5xZ5HZoGYxzLV")
                .then().statusCode(200);*/

    }
    @Story("Create a playlist")
    @Test
    public void shouldNotbeAbleTocreateAPlayListWithoutName(){
       /* String body="{\"name\": \"\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": false}";*/
        Playlist playlist=Playlist.builder().name("")
                .description("Updated New playlist description")._public(false).build();

        Response response=    post(playlist);
        assertThat(response.statusCode(),equalTo(400));
        assertError(response.as(Error.class),StatusCodes.CODE_400);

   /*   Error errorResponse=  given(getRequestSpec())
                .when()
                .body(playlist)
                .post("/users/31vwmbqo6rzsrak5et77c6t2qema/playlists")
                .then().
                spec(getResponseSpec()).
                statusCode(400).extract().as(Error.class);*/
     // MatcherAssert.assertThat(errorResponse.getError().getStatus(),equalTo(400));
      //MatcherAssert.assertThat(errorResponse.getError().getMessage(),equalTo("Missing required field: name"));

           /*     body("error.status",equalTo(400),
                        "error.message",equalTo("Missing required field: name")

                );*/
    }
    @Test
    public void verifyTheInvalidTokenRequest(){



        Playlist playlist=Playlist.builder().name("kk")
                .description("Updated New playlist description")
                ._public(false).build();

        Response response=post("123456",playlist);
        assertThat(response.statusCode(),equalTo(401));

      assertError(response.as(Error.class),StatusCodes.CODE_401);

    /*Error errorResponse=    given()
                .baseUri("https://api.spotify.com")
                .basePath("/v1")
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+"12345")
                .log().all().body(playlist)

                .when()

                .post("/users/31vwmbqo6rzsrak5et77c6t2qema/playlists")
                .then().
                spec(getResponseSpec()).
                extract().as(Error.class);*/
//        MatcherAssert.assertThat(errorResponse.getError().getStatus(),equalTo(401));
//        MatcherAssert.assertThat(errorResponse.getError().getMessage(),equalTo("Invalid access token"));




   /*     body("error.status",equalTo(401),
                        "error.message",equalTo("Invalid access token")

                );*/


    }
    @Step
    Playlist playlistBuilder(String name,String description,boolean isPublic){
        return  Playlist.builder()
                .name(name).description(description)
                ._public(isPublic).build();
    }
    @Step
    void assertStatusCode(int responseCode,int actualCode){
        assertThat(responseCode,equalTo(actualCode));

    }
    @Step
    void assertEquals(Playlist responsePlaylist,Playlist playlist){
        MatcherAssert.assertThat(responsePlaylist.getName(),equalTo(playlist.getName()));
        MatcherAssert.assertThat(responsePlaylist.get_public(),equalTo(playlist.get_public()));
        MatcherAssert.assertThat(responsePlaylist.getDescription(),equalTo(playlist.getDescription()));
    }
    @Step
    void assertError(Error errorResponse,StatusCodes statusCodes){
        MatcherAssert.assertThat(errorResponse.getError().getStatus(),equalTo(statusCodes.code));
        MatcherAssert.assertThat(errorResponse.getError().getMessage(),equalTo(statusCodes.status));


    }
}
