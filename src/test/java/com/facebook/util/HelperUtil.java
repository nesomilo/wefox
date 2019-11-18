package com.facebook.util;

import java.util.UUID;

public class HelperUtil {

	public static String getRandomFirstName() {
		return "FirstName" + " " + UUID.randomUUID().toString().substring(0, 4);
	}

	public static String getRandomLastName() {
		return "LastName" + " " + UUID.randomUUID().toString().substring(0, 4);
	}
	
	public static String getRandomEmailAddress() {
		return UUID.randomUUID().toString().substring(0, 4) + "@" + UUID.randomUUID().toString().substring(0, 4) + ".com";
	}
	
	public static String getRandomEmail1Address(String email) {
		return email.split("@")[0] + "+" + UUID.randomUUID().toString().substring(0, 3) + "@" + email.split("@")[1];
	}

}
