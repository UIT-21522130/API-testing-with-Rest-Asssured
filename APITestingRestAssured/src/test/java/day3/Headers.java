package day3;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class Headers {
//	@Test (priority = 1)
	void testHeaders() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.header("Content-type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Accept-CH", "Sec-CH-Prefers-Color-Scheme")
			.and()
			.header("Content-Encoding", "gzip");
//			Nếu k dùng log all thì có thể dùng hàm getHeaders dưới 
//			.log().all();
	}
	
	@Test (priority = 1)
	void getHeaders() {
		Response res = given()
		.when()
			.get("https://www.google.com/");
//		Get a specific header
		String headerValue = res.getHeader("Content-type");
		System.out.print("the content type is: " + headerValue);
		
//		Get all headers
		io.restassured.http.Headers headerValues = res.getHeaders();
		for (Header hd: headerValues)
		System.out.print(hd.getName()+ "  " + hd.getValue()+ "   ");
	}
	
}
