/**
 * 
 */
package com.boldsignapi.pojos;

import lombok.Builder;
import lombok.Data;

/**
 * 
 */
@Builder
@Data
public class ContactPojo {
	
	private String email;
	private String name;
	private Phone phoneNumber;
	private String jobTitle;
	private String companyName;
	
	@Data
	public static class Phone {
		
		private String countryCode;
		private String number;
	}
}