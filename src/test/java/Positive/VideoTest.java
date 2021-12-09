package Positive;

import MyBase.MyBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class VideoTest extends MyBase {

    @DisplayName("Проверка загрузки видео из директории ресурс")
    @Test
    void getContentInfo() {
        uploadedContent = given()
                .headers("Authorization", clienID)
                .multiPart("video", new File("src/test/resources/hi.mp4"))
                .expect()
                .body("success", is(true))
                .log()
                .all()
                .statusCode(200)
                .when()
                .post("https://api.imgur.com/3/upload")
                .then()
                .extract()
                .jsonPath()
                .getString("data.deletehash");

    }
}