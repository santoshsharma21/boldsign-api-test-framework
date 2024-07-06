/**
 * 
 */
package com.boldsignapi.restutils;

import com.boldsignapi.routes.Endpoints;
import com.boldsignapi.utilities.ConfigReader;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * 
 */
public class SpecBuilder {
	
	// request spec build
	public static RequestSpecification getRequestSpec() {
		RequestSpecBuilder spec = new RequestSpecBuilder();
		spec.setBaseUri(Endpoints.url)
			.addHeader("X-API-KEY", ConfigReader.getApiKey())
			.setContentType(ContentType.JSON)
			.log(LogDetail.ALL);
		RequestSpecification reqSpec = spec.build();
		return reqSpec;
	}
	
	public static RequestSpecification getRequestSpec(Object payload) {
		RequestSpecBuilder spec = new RequestSpecBuilder();
		spec.setBaseUri(Endpoints.url)
			.addHeader("X-API-KEY", ConfigReader.getApiKey())
			.setContentType(ContentType.JSON)
			.setBody(payload)
			.log(LogDetail.ALL);
		RequestSpecification reqSpec = spec.build();
		return reqSpec;
	}
	
	// response spec build
	public static ResponseSpecification getResponseSpec() {
		ResponseSpecBuilder spec = new ResponseSpecBuilder();
		spec.expectContentType(ContentType.JSON)
			.log(LogDetail.ALL);
		ResponseSpecification resSpec = spec.build();
		return resSpec;
	}
}