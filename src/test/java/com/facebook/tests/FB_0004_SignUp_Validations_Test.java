package com.facebook.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.facebook.base.BaseTest;
import com.facebook.page.LoginFacebook;

public class FB_0004_SignUp_Validations_Test extends BaseTest {

	public FB_0004_SignUp_Validations_Test() throws IOException, FileNotFoundException {
		super();
	}

	@Test
	public void fb_0001_signUp_validation_messages() throws Exception {
		LoginFacebook loginFacebook = new LoginFacebook(driver);
		loginFacebook.verifyValidationMessages("Alan", "Ford", "alan@test.com", "");
	}
	
	@Test
	public void fb_0002_signUp_validation_messages() throws Exception {
		LoginFacebook loginFacebook = new LoginFacebook(driver);
		loginFacebook.verifyValidationMessages("Alan", "Ford", "", "Pa$$w0rd");
	}
	
	@Test
	public void fb_0003_signUp_validation_messages() throws Exception {
		LoginFacebook loginFacebook = new LoginFacebook(driver);
		loginFacebook.verifyValidationMessages("Alan", "", "alan@test.com", "Pa$$w0rd");
	}
	
	@Test
	public void fb_0004_signUp_validation_messages() throws Exception {
		LoginFacebook loginFacebook = new LoginFacebook(driver);
		loginFacebook.verifyValidationMessages("", "Ford", "alan@test.com", "Pa$$w0rd");
	}

}