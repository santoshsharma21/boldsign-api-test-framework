/**
 * 
 */
package com.boldsignapi.payload;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.boldsignapi.pojos.ContactPojo;
import com.boldsignapi.pojos.ContactPojo.Phone;
import com.github.javafaker.Faker;

/**
 * 
 */
public class ContactPayload {

	// init faker
	private static Faker faker;

	// method generates fake number
	public static String getRandomPhoneNum() {
		return "12345678" + RandomStringUtils.randomNumeric(2);
	}

	// new contact payload
	public static List<ContactPojo> getNewContactPayload() {
		// faker
		faker = new Faker();

		// empty list
		List<ContactPojo> data = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			Phone ph = new Phone();
			ph.setCountryCode("+91");
			ph.setNumber(getRandomPhoneNum());

			ContactPojo cpojo = ContactPojo.builder().email(faker.internet().emailAddress())
					.name(faker.name().fullName()).phoneNumber(ph).jobTitle(faker.job().title())
					.companyName(faker.company().name()).build();

			data.add(cpojo);
		}

		return data;
	}

	// update paylod
	public static ContactPojo getContactUpdatePayload() {
		// faker
		faker = new Faker();
		
		Phone ph = new Phone();
		ph.setCountryCode("+91");
		ph.setNumber(getRandomPhoneNum());

		return ContactPojo.builder().email(faker.internet().emailAddress()).name(faker.name().fullName())
				.phoneNumber(ph).jobTitle(faker.job().title()).companyName(faker.company().name()).build();
	}
}