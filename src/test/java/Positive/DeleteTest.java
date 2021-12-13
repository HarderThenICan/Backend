package Positive;

import MyBase.MyBase;
import image.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Endpoins.Endpoints.DELETE;
import static Endpoins.Endpoints.IMAGE;
import static io.restassured.RestAssured.given;

public class DeleteTest extends MyBase {
    private String uploadedContent;

    @BeforeEach
    void deleteUp() {
        uploadedContent = given(headerImage)
                .post(IMAGE)
                .then()
                .extract()
                .response()
                .as(Response.class)
                .getData()
                .getDeletehash();

    }

    @DisplayName("Проверка удаления картинки")
    @Test
    void delete() {
        given(header, checkResponse)
                .delete(DELETE, uploadedContent);
    }
}