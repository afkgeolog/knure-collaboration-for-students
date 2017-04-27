package access;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

/**
 * Created by Vladyslav Dovhopol on 4/27/17.
 * Test Greeting Controller.
 */
public class GreetingControllerTest {

    @Test
    public void GET_NoPayload_Correct() {
        get("/greeting").
        then().assertThat().
                statusCode(200).and().
                contentType(ContentType.HTML);
    }
}
