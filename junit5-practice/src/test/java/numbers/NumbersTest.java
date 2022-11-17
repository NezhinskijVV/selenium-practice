package numbers;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class NumbersTest {
    public static final String NUMBERS_URI = "http://numbersapi.com";
    public static final String ID_PATH = "/{id}";


    @Test
    public void shouldHaveCorrectGet2() {

        given()
                .baseUri(NUMBERS_URI)
                .pathParam("id", 2)
                .when()
                .get(ID_PATH)
                .then()
                .log().all()
                .statusCode(200);

    }
}