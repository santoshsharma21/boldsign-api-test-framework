/**
 * 
 */
package com.boldsignapi.api;

import com.boldsignapi.restutils.HttpMethod;
import com.boldsignapi.routes.Endpoints;

import io.restassured.response.Response;

/**
 * 
 */
public class ContactApi {
	
	// fetch contact
	public static Response retrieveContact(String id) {
		return HttpMethod.get(Endpoints.GET_CONTACT, id);
	}
	
	// create contacts
	public static Response createContacts(Object payload) {
		return HttpMethod.post(Endpoints.NEW_CONTACT, payload);
	}
	
	// update contacts
	public static Response updateContact(Object payload, String id) {
		return HttpMethod.put(Endpoints.UPDATE_CONTACT, payload, id);
	}
	
	// delete contact
	public static Response deleteContact(String id) {
		return HttpMethod.delete(Endpoints.DELETE_CONTACT, id);
	}
}