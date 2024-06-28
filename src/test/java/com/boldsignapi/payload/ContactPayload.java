/**
 * 
 */
package com.boldsignapi.payload;

import java.util.ArrayList;
import java.util.List;

import com.boldsignapi.pojos.ContactPojo;
import com.boldsignapi.pojos.ContactPojo.Phone;
import com.github.javafaker.Faker;

/**
 * 
 */
public class ContactPayload {

	// init faker
	private static Faker faker;

	// new contact payload
	public static List<ContactPojo> getNewContactPayload() {
		// faker
		faker = new Faker();

		// empty list
		List<ContactPojo> data = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			Phone ph = new Phone();
			ph.setCountryCode("+1");
			ph.setNumber(faker.phoneNumber().cellPhone());

			ContactPojo cpojo = ContactPojo.builder().email(faker.internet().emailAddress())
					.name(faker.name().fullName()).phoneNumber(ph).jobTitle(faker.job().title())
					.companyName(faker.company().name()).build();

			data.add(cpojo);
		}

		return data;
	}

	// update paylod
	public static ContactPojo getContactUpdatePayload() {

		Phone ph = new Phone();
		ph.setCountryCode("+1");
		ph.setNumber(faker.phoneNumber().cellPhone());

		return ContactPojo.builder().email(faker.internet().emailAddress()).name(faker.name().fullName())
				.phoneNumber(ph).jobTitle(faker.job().title()).companyName(faker.company().name()).build();
	}
}