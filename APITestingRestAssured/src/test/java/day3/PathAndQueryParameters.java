package day3;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {
	@Test
	void testQueryAndPathParam() {
		given()
			.pathParam("mypath", "users")
			.queryParam("page", "2")
			.queryParam("id", "5")
		.when()
			// chỉ cần truyền pathParam thôi là tự hiểu queryParam ở sau
			.get("https://reqres.in/api/{mypath}")
		.then()
			.statusCode(200)
			.log().all();
	}
}
