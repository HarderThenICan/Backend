package Positive;

import MyBase.MyBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ImageInformationTest extends MyBase {
    String imageHash;

    @BeforeEach
    void titleUo() {
        imageHash = given()
                .headers("Authorization", token)
                .multiPart("image", new File("src/test/resources/images.jpg"))
                .expect()
                .body("success", is(true))
                .statusCode(200)
                .when()
                .post("https://api.imgur.com/3/image")
                .then()
                .extract()
                .jsonPath()
                .getString("data.id");


    }

    @DisplayName("изменение заголовка")
    @Test
    void uploadInfo() {
        given()
                .headers("Authorization", token)
                .param("title", "description")
                .when()
                .post("https://api.imgur.com/3/image/{imageHash}", imageHash)
                .then()
                .statusCode(200);

    }

}