/**
 * 
 */
package com.boldsignapi.utilities;

import org.json.JSONObject;

import io.restassured.response.Response;

/**
 * 
 */
public class TestUtils {

	// reusable methods
	// method return status code
	public static int getStatusCode(Response response) {
		return response.getStatusCode();
	}

	// returns string from inner jsonArray in response
	public static String getStringFromInnerJArray(Response response, String jsonArrayName, int idxOfJsonObj,
			String key) {
		JSONObject jsonObj = new JSONObject(response.asString());
		String stringValue = jsonObj.getJSONArray(jsonArrayName).getJSONObject(idxOfJsonObj).getString(key);
		return stringValue;
	}

	// returns string from inner jsonObject
	public static String getStringFromInnerJsonObj(Response response, String jsonObjName, String key) {
		JSONObject jsonObj = new JSONObject(response.asString());
		String stringValue = jsonObj.getJSONObject(jsonObjName).getString(key);
		return stringValue;
	}

	// returns string from jsonObject
	public static String getStringFromResponse(Response response, String key) {
		JSONObject jsonObj = new JSONObject(response.asString());
		String stringValue = jsonObj.getString(key);
		return stringValue;
	}
}