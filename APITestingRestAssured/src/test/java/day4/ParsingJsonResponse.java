package day4;
import org.json.JSONObject;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class ParsingJsonResponse {
//	@Test(priority = 1)
	void testJsonParse() {
		// cách 1
		/*
	    given()
	        .contentType("ContentType/JSON")	
	    .when()
	        .get("http://localhost:3000/book")
	    
	    .then()
	        .statusCode(200)
	        .header("Content-Type", "application/json")
	        .body("[3].title", equalTo("Life in the Fast Lane"));
	    */
		// cách 2
		Response res = given()
				.contentType(ContentType.JSON)	
		    .when()
			        .get("http://localhost:3000/book");
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json");
		String bookname = res.jsonPath().get("[3].title").toString();
		Assert.assertEquals(bookname, "Life in the Fast Lane");
	}
	
	
	@Test(priority = 2)
	void testJsonParseBodyData() {
		
		Response res = given()
				.contentType(ContentType.JSON)	
		    .when()
			        .get("http://localhost:3000/book");
//		JSONObject class
		JSONArray jsonArray = new JSONArray(res.asString());
		
		for (int i = 0; i < jsonArray.length(); i++) {
	        String bookTitle = jsonArray.getJSONObject(i).getString("title");
	        System.out.println(bookTitle);
	    }
		double totalPrice = 0;
		for (int i = 0; i< jsonArray.length(); i++) {
			Double price = jsonArray.getJSONObject(i).getDouble("price");
			totalPrice += price;
		}
		System.out.print("The total price is: " + totalPrice);
		Assert.assertEquals(totalPrice, 103.94999999999999);
	}
}
