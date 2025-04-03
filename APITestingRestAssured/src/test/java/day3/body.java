package day3;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class body {
	@Test (priority = 1)
	void testCookies() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			// in ra body, cookies, headers
//			.log().all();
			// muốn in ra cái nào thì truy suất tới
			.log().body();
//			.log().cookies();
	}
	
}
