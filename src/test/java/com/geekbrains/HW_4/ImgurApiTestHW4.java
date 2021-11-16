package com.geekbrains.HW_4;

import com.geekbrains.restApi.imgur.ImgurApiParams;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class ImgurApiTestHW4 {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = ImgurApiParams.API_URL + "/" + ImgurApiParams.API_VERSION;
    }

    @DisplayName("Тест на получение базовой информации об аккаунте")
    @Test
    @Order(1)
    void testAccountBase() {
        String url = "account/" + "cakettest";

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectBody("success", is(true))
                .expectBody("data", is(true))
                .expectStatusCode(200)
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .spec(responseSpecification)
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Тест обновления информации о картинке")
    @Test
    @Order(2)
    void testUpdateImageInfo() {
        String imageHash = "HSoCx0H";
        String url = "image/" + imageHash;

        //   given().get("").body().jsonPath().getString("data.id");

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFormParam("title", "The reaction to a BUG")
                .addFormParam("description", "The reaction to a BUG")
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectBody("success", is(true))
                .expectBody("data", is(true))
                .expectStatusCode(200)
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .spec(requestSpecification)
                .expect()
                .log()
                .all()
                .spec(responseSpecification)
                .when()
                .post(url);
    }

    @DisplayName("Тест на получение картинки аккаунта")
    @Test
    @Order(3)
    void testAccountImages() {
        String url = "account/me/images";

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFormParam("title", "The reaction to a BUG")
                .addFormParam("description", "The reaction to a BUG")
                .addFormParam("datetime", "1635941352")
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectBody("success", is(true))
                .expectBody("data", is(true))
                .expectStatusCode(200)
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .spec(requestSpecification)
                .expect()
                .log()
                .all()
                .spec(responseSpecification)
                .when()
                .get(url);
    }

    @DisplayName("Тест на получение всех картинок")
    @Test
    @Order(4)
    void testImages() {
        //    String page = "0";
        String url = "account/" + "cakettest" + "images/" + "0";

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFormParam("title", "The reaction to a BUG")
                .addFormParam("description", "The reaction to a BUG")
                .addFormParam("datetime", "1635941352")
                .addFormParam("animated", "false")
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectBody("success", is(true))
                .expectBody("data", is(true))
                .expectStatusCode(200)
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .spec(requestSpecification)
                .expect()
                .log()
                .all()
                .spec(responseSpecification)
                .when()
                .get(url);
    }

    @DisplayName("Тест на получение картинки")
    @Test
    @Order(5)
    void testImage() {
        String imageId = "HSoCx0H";
        String url = "account/" + "cakettest" + "image/" + "imageId";

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFormParam("title", "The reaction to a BUG")
                .addFormParam("description", "The reaction to a BUG")
                .addFormParam("datetime", "1635941352")
                .addFormParam("type", "image/png")
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectBody("success", is(true))
                .expectBody("data", is(true))
                .expectStatusCode(200)
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .spec(requestSpecification)
                .expect()
                .log()
                .all()
                .spec(responseSpecification)
                .when()
                .get(url);
    }

    @DisplayName("Тест на подсчет одинаковых картинок")
    @Test
    @Order(6)
    void testImageCount() {
        String url = "account/" + "cakettest" + "image/count";

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectHeader("ETag", "\"61929e97-10e3\"")
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .log()
                .all()
                .spec(responseSpecification)
                .when()
                .get(url);
    }

    @DisplayName("Тест на получение id картинки")
    @Test
    @Order(7)
    void testImageIDs() {
        //    String page = "0";
        String url = "account/" + "cakettest" + "image/ids/" + "0";

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFormParam("data", "HSoCx0H")
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectHeader("Content-Length", "4323")
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .spec(requestSpecification)
                .expect()
                .log()
                .all()
                .spec(responseSpecification)
                .when()
                .get(url);
    }

    @DisplayName("Тест на получение id комментария")
    @Test
    @Order(8)
    void testComment() {
        String commentId = "2155918857";
        String url = "account/" + "cakettest" + "comment/" + "commentId";

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFormParam("id", "2155918857")
                .addFormParam("image_id", "ImuVqZ8")
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .spec(requestSpecification)
                .expect()
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Тест на получение нового комментария")
    @Test
    @Order(9)
    void testComments() {
        //    String page = "0";
        String commentSort = "newest";
        String url = "account/" + "cakettest" + "comments/" + "commentSort" + "0";

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFormParam("id", "2155920045")
                .addFormParam("image_id", "ImuVqZ8")
                .addFormParam("comment", "com 2")
                .addFormParam("author", "cakettest")
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .spec(requestSpecification)
                .expect()
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Тест на получение альбома")
    @Test
    @Order(10)
    void testAlbum() {
        String albumHash = "ImuVqZ8";
        String url = "album/" + "albumHash";

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFormParam("id", "ImuVqZ8")
                .addFormParam("title", "reaction to a bug")
                .addFormParam("datatime", "1635941350")
                .addFormParam("cover", "HSoCx0H")
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .spec(requestSpecification)
                .expect()
                .log()
                .all()
                .when()
                .get(url);
    }
}
