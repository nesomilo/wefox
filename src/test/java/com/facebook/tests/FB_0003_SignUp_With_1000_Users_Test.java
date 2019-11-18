package com.facebook.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.facebook.base.BaseTest;
import com.facebook.page.LoginFacebook;

public class FB_0003_SignUp_With_1000_Users_Test extends BaseTest {

	public FB_0003_SignUp_With_1000_Users_Test() throws IOException, FileNotFoundException {
		super();
	}

	@Test
	public void fb_0003_signUp_with_thousand_users_test() throws Exception {
		LoginFacebook loginFacebook = new LoginFacebook(driver);
		for (int i = 0; i < 1000; i++) {
			loginFacebook.enterSignUpData(fb_properties.getValue("FB.TEST.EMAIL"));
		}
	}

}