package Positive;

import MyBase.MyBase;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static Endpoins.Endpoints.UPLOAD;
import static io.restassured.RestAssured.given;

public class VideoTest extends MyBase {
    private static RequestSpecification headerVideo;

    @BeforeEach
    void beforeVideo() {
        headerVideo = new RequestSpecBuilder()
                .addHeader("Authorization", clienID)
                .addMultiPart("image", new File("src/test/resources/images.jpeg"))
                .build();

    }

    @DisplayName("Проверка загрузки видео из директории ресурс")


    @Test
    void getContentInfo() {
        given(headerVideo, checkResponse)
                .post(UPLOAD);


    }
}