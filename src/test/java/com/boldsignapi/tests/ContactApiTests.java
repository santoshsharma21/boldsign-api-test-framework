/**
 * 
 */
package com.boldsignapi.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.boldsignapi.api.ContactApi;
import com.boldsignapi.payload.ContactPayload;
import com.boldsignapi.pojos.ContactPojo;
import com.boldsignapi.utilities.TestUtils;

import io.restassured.response.Response;

/**
 * 
 */
public class ContactApiTests {
	// init var to store id
	private String contactId;

	// create contact
	@Test(priority = 0, description = "this test will create new contacts")
	public void createContactsTests(ITestContext context) {

		List<ContactPojo> newContactPayload = ContactPayload.getNewContactPayload();
		context.setAttribute("payload", newContactPayload);
		Response response = ContactApi.createContacts(newContactPayload);

		// capture and store generated contact id
		contactId = TestUtils.getStringFromInnerJArray(response, "createdContacts", 0, "id");
		context.setAttribute("id", contactId);
		System.out.println("GENERATED-CONTACT-ID = " + contactId);

		// validation
		Assert.assertEquals(TestUtils.getStatusCode(response), 200);
		Assert.assertEquals(TestUtils.getStringFromInnerJArray(response, "createdContacts", 0, "email"),
				newContactPayload.get(0).getEmail());
	}

	// fetch contact by id
	@Test(priority = 1, description = "this test will fetch contact by id")
	public void fetchContactTest(ITestContext context) {
		String id = context.getAttribute("id").toString();
		Response response = ContactApi.retrieveContact(id);

		// validation
		Assert.assertEquals(TestUtils.getStatusCode(response), 200);
		Assert.assertEquals(TestUtils.getStringFromResponse(response, "id"), id);
	}

	// update contact by id
	@Test(priority = 2, description = "this test will update existing contact by id")
	public void updateContactTest(ITestContext context) {
		ContactPojo updatePayload = ContactPayload.getContactUpdatePayload();
		String id = context.getAttribute("id").toString();
		Response response = ContactApi.updateContact(updatePayload, id);

		// validation
		Assert.assertEquals(TestUtils.getStatusCode(response), 200);
	}
	
	// delete contact
	@Test(priority = 3, description = "this test will delete contact by id")
	public void deleteContactTest(ITestContext context) {
		String id = context.getAttribute("id").toString();
		Response response = ContactApi.deleteContact(id);

		// validation
		Assert.assertEquals(TestUtils.getStatusCode(response), 204);
	}
}