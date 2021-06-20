package com.lego.util;

import java.util.UUID;

public class HelperUtil {
	
	// In this class I usually store some help methods that can be used anywhere

	public static String getRandomString(int n) {
		return UUID.randomUUID().toString().substring(0, n);
	}
}