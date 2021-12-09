package Positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import MyBase.MyBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AccountTest extends MyBase {


    @DisplayName("Проверка авторизации пользователя")
    @Test
    void getAccountInfo() {
        given()
                .headers("Authorization", clienID)
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .then()
                .statusCode(200);
    }


    @DisplayName("Проверка авторизации пользователя")
    @Test
    void getAccountInfoLog() {
        given()
                .headers("Authorization", clienID)
                .log()
                .method()
                .expect()
                .statusCode(200)
                .body("success", equalTo(true))
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .prettyPeek();


    }


    @DisplayName("Проверка кода авторизации пользователя  ")
    @Test
    void getAccountInfoCode() {
        given()
                .headers("Authorization", clienID)
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .then()
                .statusCode(200);


    }


}