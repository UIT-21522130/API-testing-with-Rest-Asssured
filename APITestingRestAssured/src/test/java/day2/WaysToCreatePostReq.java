package day2;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

//Different ways to create POST request body
//1) Post request body using Hashmap
//2) Post request body creation using using Org. JSON
//3) Post request body creation using POJO class
//4) Post request using external json file data
public class WaysToCreatePostReq {
//	@Test(priority = 1)
	void testPostUsingHashMap() {
		HashMap data = new HashMap();
		data.put("name", "huong");
		data.put("gender", "female");
		data.put("physics", "100");
		
		String courseArr[] = {"C", "C++"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/student")
		.then() // Verify the response
			.statusCode(201)
			.body("name", equalTo("huong"))
			.body("gender", equalTo("female"))
			.body("physics", equalTo("100"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.log().all();
	}
	
//	@Test(priority = 1)
	void testPostUsingOrgJson() {
		JSONObject data = new JSONObject();
		data.put("name", "huong");
		data.put("gender", "female");
		data.put("physics", "100");
		
		String courseArr[] = {"C", "C++"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/student")
		.then() // Verify the response
			.statusCode(201)
			.body("name", equalTo("huong"))
			.body("gender", equalTo("female"))
			.body("physics", equalTo("100"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.log().all();
	}
	
	
	@Test(priority = 1)
	void testPostUsingPOJO() {
		Pojo_Post data = new Pojo_Post();
		data.setName("huong");
		data.setGender("female");
		data.setPhysics("100");
		String courseArr[] = {"C", "C++"};
		data.setCourses(courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/student")
		.then() // Verify the response
			.statusCode(201)
			.body("name", equalTo("huong"))
			.body("gender", equalTo("female"))
			.body("physics", equalTo("100"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.log().all();
	}
	
	
	
	
//	@Test(priority = 2)
	void testDelete() {
		given()

		.when()
			.post("http://localhost:3000/student/e119" )
		.then() // Verify the response
			.statusCode(204)
			.log().all();
	}
	

}
