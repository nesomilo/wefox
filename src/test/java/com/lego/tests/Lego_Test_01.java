package com.lego.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.lego.base.BaseTest;
import com.lego.page.FourPlusPage;
import com.lego.page.HomePage;

public class Lego_Test_01 extends BaseTest {

	public Lego_Test_01() throws IOException, FileNotFoundException {
		super();
	}

	@Test
	public void lego_test_01() throws Exception {
		HomePage homePage = new HomePage(driver, LEGO_PROPERTIES);
		homePage.acceptTheCookies();
		homePage.navigateOnProduct();
		FourPlusPage fourPlus = new FourPlusPage(driver);
		fourPlus.verifyAndNavigate();
		fourPlus.checkPaycheck();
	}

}