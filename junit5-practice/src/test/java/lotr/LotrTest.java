package lotr;

import io.restassured.response.ValidatableResponse;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ru.buttonone.model.BookOld;

import java.util.List;

import static io.restassured.RestAssured.given;

@DisplayName("С API властелина колец должны")
public class LotrTest {

    public static final String LOTR_API_URL = "https://the-one-api.dev/v2";

    @DisplayName(" корректно получать книги")
    @Test
    public void shouldHaveCorrectGetBooksTest() {
        ValidatableResponse validatableResponse = given()
                .baseUri(LOTR_API_URL)
                .when()
                .get("/book")
                .then()
                //.log().all()
                .statusCode(200);

        System.out.println(validatableResponse.extract().body().toString());

        List<BookOld> bookOldList = validatableResponse
                .extract()
                .body()
                .jsonPath().getList("docs", BookOld.class);

        System.out.println(bookOldList);

        MatcherAssert.assertThat(bookOldList, Matchers.containsInAnyOrder(new BookOld("The Fellowship Of The Ring"),
                new BookOld("The Return Of The King"),
                new BookOld("The Two Towers")
        ));
    }

    @Test
    public void sleepTest1000() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " => begin");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " => end");
    }

    @Test
    public void sleepTest2000() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " => begin");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " => end");
    }


    @Order(0)
    @Test
    public void sleepTest3000() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " => begin");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " => end");
    }
}