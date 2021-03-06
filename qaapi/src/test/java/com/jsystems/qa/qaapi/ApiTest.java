package com.jsystems.qa.qaapi;

import com.sun.org.apache.regexp.internal.RE;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertTrue;

@DisplayName("Api test")
@Tag("ApiTest")
public class ApiTest {

    @Test
    public void firstApiTest(){
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));
    }

    @Test
    @DisplayName("List of users")
    public void shouldReturnListOfUsers() {
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie",notNullValue())
                .body("[0].imie",equalTo("Piotr"))
                .body("[0].nazwisko",notNullValue())
                .body("[0].nazwisko",equalTo("Kowalski"))
                //.body("[0].device[0].device.model",notNullValue())   //dla kropek w nazwie pola nie dziala, dlatego ze jest imie, nazwisko ale tez device.model
                ;
    }

    @Test
    @DisplayName("sds")
    public void jsonPathTest()  {
       List<User> users = RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", User.class)

        ;
       assertTrue(users.get(0).imie.equals("Piotr"));
       assertTrue(users.get(0).nazwisko.equals("Kowalski"));
       assertTrue(users.get(0).device.get(0).type.equals("computer"));
       assertTrue(users.get(0).device.get(0).deviceModel.get(0).screenSize == 17);
       assertTrue(users.size() > 0);
    }
}
