package Positive;

import MyBase.MyBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Endpoins.Endpoints.ACCOUNT;
import static io.restassured.RestAssured.given;

public class AccountTest extends MyBase {


    @DisplayName("Проверка авторизации пользователя")
    @Test
    void getAccountInfoLog() {
        given(header, checkResponse)
                .get(ACCOUNT, username);


    }


}