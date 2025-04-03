package day3;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class Cookies {
//	@Test (priority = 1)
	void testCookies() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.cookies("AEC","AVcja2fzrk_wmx3dhObrz8QYxPliWC7ux1C5bn5BoZf5kN4zvP6XCl-9iTc")
			.log().all();
	}
	@Test (priority = 1)
	void getCookiesInfor() {
		Response res = given()
		.when()
			.get("https://www.google.com/");
//		String cookie_value = res.getCookie("AEC");
//		System.out.print("Value of cookie is: "+ cookie_value);
		Map<String, String> cookie_values = res.getCookies();
//		System.out.print("Value of cookie is: "+ cookie_values.keySet());
		for (String k: cookie_values.keySet()) {
			String cookie_value = res.getCookie(k);
			System.out.print(k + "      "+ cookie_value);
		}
	}
}
