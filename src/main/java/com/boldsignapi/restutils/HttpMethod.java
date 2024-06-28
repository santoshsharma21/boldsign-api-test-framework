/**
 * 
 */
package com.boldsignapi.restutils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * 
 */
public class HttpMethod {
	
	// GET request
	public static Response get(String endpoint, String id) {
	
		RequestSpecification reqSpec = SpecBuilder.getRequestSpec();
		ResponseSpecification resSpec = SpecBuilder.getResponseSpec();
		
		Response response = RestAssured.given()
				.spec(reqSpec)
				.pathParam("id", id)
				.accept(ContentType.JSON)
				
				.when()
					.get(endpoint)
					
				.then()
					.spec(resSpec)
					.log().all().extract().response();
		
		return response;	
	}
	
	// POST request
	public static Response post(String endpoint, Object payload) {
		
		RequestSpecification reqSpec = SpecBuilder.getRequestSpec(payload);
		ResponseSpecification resSpec = SpecBuilder.getResponseSpec();
		
		Response response = RestAssured.given()
				.spec(reqSpec)
				.accept("*/*")
				
				.when()
					.post(endpoint)
					
				.then()
					.spec(resSpec)
					.log().all().extract().response();
		
		return response;
	}
	
	// PUT request
	public static Response put(String endpoint, Object payload, String id) {
		
		RequestSpecification reqSpec = SpecBuilder.getRequestSpec(payload);
		ResponseSpecification resSpec = SpecBuilder.getResponseSpec();
		
		Response response = RestAssured.given()
				.spec(reqSpec)
				.accept("*/*")
				.pathParam("id", id)
				
				.when()
					.put(endpoint)
					
				.then()
					.spec(resSpec)
					.log().all().extract().response();
		
		return response;
	}
	
	// DELETE request
	public static Response delete(String endpoint, String id) {
		
		RequestSpecification reqSpec = SpecBuilder.getRequestSpec();
		ResponseSpecification resSpec = SpecBuilder.getResponseSpec();
		
		Response response = RestAssured.given()
				.spec(reqSpec)
				.accept("*/*")
				.pathParam("id", id)
				
				.when()
					.delete()
					
				.then()
					.spec(resSpec)
					.log().all().extract().response();
		
		return response;
	}
}
