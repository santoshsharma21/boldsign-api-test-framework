/**
 * 
 */
package com.boldsignapi.restutils;

import com.boldsignapi.extentreport.ReportLogs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;

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
				.queryParam("id", id)
				.accept(ContentType.JSON)
				
				.when()
					.get(endpoint)
					
				.then()
					.spec(resSpec)
					.log().all().extract().response();
		
		updateRequestDetails(reqSpec, "GET", endpoint, false);
		updateResponseDetails(response, true);
		
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
		
		updateRequestDetails(reqSpec, "POST", endpoint, true);
		updateResponseDetails(response, true);
		
		return response;
	}
	
	// PUT request
	public static Response put(String endpoint, Object payload, String id) {
		
		RequestSpecification reqSpec = SpecBuilder.getRequestSpec(payload);
		//ResponseSpecification resSpec = SpecBuilder.getResponseSpec();
		
		Response response = RestAssured.given()
				.spec(reqSpec)
				.accept("*/*")
				.queryParam("id", id)
				
				.when()
					.put(endpoint)
					
				.then()
					
					.log().all().extract().response();
		
		updateRequestDetails(reqSpec, "PUT", endpoint, true);
		updateResponseDetails(response, false);
		
		return response;
	}
	
	// DELETE request
	public static Response delete(String endpoint, String id) {
		
		RequestSpecification reqSpec = SpecBuilder.getRequestSpec();
		//ResponseSpecification resSpec = SpecBuilder.getResponseSpec();
		
		Response response = RestAssured.given()
				.spec(reqSpec)
				.accept("*/*")
				.queryParam("id", id)
				
				.when()
					.delete(endpoint)
					
				.then()
					.log().all().extract().response();
		
		updateRequestDetails(reqSpec, "DELETE", endpoint, false);
		updateResponseDetails(response, false);
		
		return response;
	}
	
	// log request details
	public static void updateRequestDetails(RequestSpecification reqSpec, String method, String endpoint, boolean withPayload) {
		QueryableRequestSpecification query = SpecificationQuerier.query(reqSpec);
		
		if(withPayload) {
			ReportLogs.logText("Endpoint - " + endpoint);
			ReportLogs.logText("Http Method - " + method);
			ReportLogs.logText("Request Payload Details");
			ReportLogs.logJson(query.getBody().toString());
		} else {
			ReportLogs.logText("Endpoint - " + endpoint);
			ReportLogs.logText("Http Method - " + method);
		}
	}
	
	// log request details
	public static void updateResponseDetails(Response response, boolean withResponseBody) {
		if(withResponseBody) {
			ReportLogs.logText("Status Code - " + response.getStatusCode());
			ReportLogs.logText("Response Payload Details");
			ReportLogs.logJson(response.getBody().asPrettyString());
		} else {
			ReportLogs.logText("Status Code - " + response.getStatusCode());
		}
	}
}