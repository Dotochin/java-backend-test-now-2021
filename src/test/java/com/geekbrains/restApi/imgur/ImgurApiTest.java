package com.geekbrains.restApi.imgur;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class ImgurApiTest {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = ImgurApiParams.API_URL + "/" + ImgurApiParams.API_VERSION;
    }

    @DisplayName("Тест на получение базовой информации об аккаунте")
    @Test
    void testAccountBase() {
        String url = "account/" + "cakettest";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .statusCode(is(200))
                .body("success", is(true))
                .body("status", is(200))
                .body("data.reputation", is(12))
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Тест обновления информации о картинке")
    @Test
    void testUpdateImageInfo() {
        String imageHash = "HSoCx0H";
        String url = "image/" + imageHash;

     //   given().get("").body().jsonPath().getString("data.id");

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .formParam("title", "The reaction to a BUG")
                .formParam("description", "The reaction to a BUG")
                .expect()
                .log()
                .all()
                .statusCode(is(200))
                .body("success", is(true))
                .body("data", is(true))
                .when()
                .post(url);
    }

    @DisplayName("Тест на получение картинки аккаунта")
    @Test
    void testAccountImages() {
        String url = "account/me/images";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .formParam("title", "The reaction to a BUG")
                .formParam("description", "The reaction to a BUG")
                .formParam("datetime", "1635941352")
                .expect()
                .log()
                .all()
                .statusCode(is(200))
                .body("success", is(true))
                .when()
                .get(url);
    }

    @DisplayName("Тест на получение всех картинок")
    @Test
    void testImages() {
    //    String page = "0";
        String url = "account/" + "cakettest" + "images/" + "0";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .formParam("title", "The reaction to a BUG")
                .formParam("description", "The reaction to a BUG")
                .formParam("datetime", "1635941352")
                .formParam("animated", "false")
                .expect()
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Тест на получение картинки")
    @Test
    void testImage() {
        String imageId = "HSoCx0H";
        String url = "account/" + "cakettest" + "image/" + "imageId";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .formParam("title", "The reaction to a BUG")
                .formParam("description", "The reaction to a BUG")
                .formParam("datetime", "1635941352")
                .formParam("type", "image/png")
                .expect()
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Тест на подсчет одинаковых картинок")
    @Test
    void testImageCount() {
        String url = "account/" + "cakettest" + "image/count";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .log()
                .all()
                .headers("ETag", "\"618ab769-10e3\"")
                .when()
                .get(url);
    }

    @DisplayName("Тест на получение id картинки")
    @Test
    void testImageIDs() {
    //    String page = "0";
        String url = "account/" + "cakettest" + "image/ids/" + "0";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .formParam("data", "HSoCx0H")
                .expect()
                .log()
                .all()
                .headers("Content-Length", "4323")
                .when()
                .get(url);
    }

    @DisplayName("Тест на получение id комментария")
    @Test
    void testComment() {
        String commentId = "2155918857";
        String url = "account/" + "cakettest" + "comment/" + "commentId";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .formParam("id", "2155918857")
                .formParam("image_id", "ImuVqZ8")
                .expect()
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Тест на получение нового комментария")
    @Test
    void testComments() {
        //    String page = "0";
        String commentSort = "newest";
        String url = "account/" + "cakettest" + "comments/" + "commentSort" + "0";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .formParam("id", "2155920045")
                .formParam("image_id", "ImuVqZ8")
                .formParam("comment", "com 2")
                .formParam("author", "cakettest")
                .expect()
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Тест на получение альбома")
    @Test
    void testAlbum() {
        String albumHash = "ImuVqZ8";
        String url = "album/" + "albumHash";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .formParam("id", "ImuVqZ8")
                .formParam("title", "reaction to a bug")
                .formParam("datatime", "1635941350")
                .formParam("cover", "HSoCx0H")
                .expect()
                .log()
                .all()
                .when()
                .get(url);
    }
}
