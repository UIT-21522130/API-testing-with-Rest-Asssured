package day6;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class RandomData {
	public String name = "";
	public String physics = "";
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "http://localhost:3000";
	}
	@BeforeTest
	public void prepareTestData() {
		
	}
	@Test
	public void testAddStudent() {
		
	}
}
