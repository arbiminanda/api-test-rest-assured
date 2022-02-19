package apiTest;

import payload.ListAPI;
import payload.createMockUpAPIdata;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class createMockUpAPI {

	ListAPI ip = new ListAPI();
	Response response;
	createMockUpAPIdata createMockUpAPIdata = new createMockUpAPIdata();
	public String api_id;
		
	@BeforeMethod
    public void setUp() {
        RestAssured.baseURI = ip.getApiCreateMockUpAPI();
    }
	
	@Test(priority = 0)
    public void createAPI(){
        response = given()
                .header("Content-Type", "application/json")
                .body(createMockUpAPIdata.createMockUpAPI().toJSONString())
                .when()
                .post("mock")
                .then()
                .log().body()
                .statusCode(201)
                .extract().response();
        api_id = response.getBody().path("id");
    }
	
	@Test(priority = 1)
	public void testNewAPI() {
		RestAssured.baseURI = "http://run.mocky.io/v3/";
		response = given()
                .when()
                .get(api_id)
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
	}
	
}
