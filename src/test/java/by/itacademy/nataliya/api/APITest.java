package by.itacademy.nataliya.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class APITest {
    @Test
    public void testCreateNewUser() {
        String endPoint = "http://users.bugred.ru/tasks/rest/doregister";
        String name = "robert7"; // при запуске необходимо изменить имя
        String email = "robert7@gmail.com"; // при запуске необходимо изменить email
        String password = "123"; // пароль не ассертим
        String requestBody = String.format("{\"name\":\"%s\",\"email\":\"%s\",\"password\":\"%s\"}", name, email, password);
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(endPoint)
                .then()
                .extract().response();
        // пароль при ассерте возвращается в зашифрованном виде?
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(response.jsonPath().getString("name"), "robert7"); // изменить на актуальное
        Assert.assertEquals(response.jsonPath().getString("email"), "robert7@gmail.com"); // изменить на актуальное
    }

    @Test
    public void testCreateNewUserWithInvalidEmail() {
        String endPoint = "http://users.bugred.ru/tasks/rest/doregister";
        String name = "robert";
        String email = "robert.gmail.com";
        String password = "123";
        String requestBody = String.format("{\"name\":\"%s\",\"email\":\"%s\",\"password\":\"%s\"}", name, email, password);
        Response response = given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post(endPoint)
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertNull(response.jsonPath().getString("email"));
    }

    @Test
    public void testReadUser() {
        String endPoint = "http://users.bugred.ru/tasks/rest/getuser";
        String email = "robert7@gmail.com";
        String requestBody = String.format("{\"email\":\"%s\"}", email);
        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .get(endPoint)
                .then().statusCode(200)
                .body("email", is(email));
    }

    @Test
    void testReadUserWithInvalidEmail() {
        String endPoint = "http://users.bugred.ru/tasks/rest/getuser";
        String email = "robert.gmail.com";
        String requestBody = String.format("{\"email\":\"%s\"}", email);
        Response response = given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .get(endPoint)
                .then().extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertNull(response.jsonPath().getString("email"));
    }
     @Test
    void testUpdateUser() {
        String endPoint = "http://users.bugred.ru/tasks/rest/fullupdateuser";
        String email = "robert7@gmail.com";
        String hobby = "learning";
        String inn = "012345678901";
        String birthday = "01.05.2000";
        String date_start = "28.11.2022";
               String requestBody = String.format("{\"email\":\"%s\",\"hobby\":\"%s\",\"inn\":\"%s\",\"birthday\":\"%s\",\"date_start\":\"%s\"}", email, hobby, inn, birthday, date_start);
        given().header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .log().all()
                .post(endPoint)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    @Test
    void testDeleteUsers() {
        String endPoint = "http://users.bugred.ru/tasks/rest/deleteuser";
        String email = "robert7@gmail.com";
        String requestBody = String.format("{\"email\":\"%s\"}", email);
        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .delete(endPoint)
                .then().statusCode(200)
                .extract().response();
    }

    @Test
    void testDeleteUserWithInvalidData() {
        String endPoint = "http://users.bugred.ru/tasks/rest/deleteuser";
        String email = "robert.gmail.com";
        String requestBody = String.format("{\"email\":\"%s\"}", email);
        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .delete(endPoint)
                .then().statusCode(200)
                .extract().response();
    }
}




