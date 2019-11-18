package com.facebook.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.facebook.base.BaseTest;
import com.facebook.page.LoginFacebook;

public class FB_0002_SignUp_Test extends BaseTest {

	public FB_0002_SignUp_Test() throws IOException, FileNotFoundException {
		super();
	}

	@Test
	public void fb_0002_signUp_test() throws Exception {
		LoginFacebook loginFacebook = new LoginFacebook(driver);
		loginFacebook.enterSignUpData(fb_properties.getValue("FB.TEST.EMAIL"));
	}

}
