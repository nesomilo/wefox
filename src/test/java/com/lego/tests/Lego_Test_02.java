package com.lego.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.lego.base.BaseTest;
import com.lego.page.HomePage;
import com.lego.page.ProductPreview;

public class Lego_Test_02 extends BaseTest {

	public Lego_Test_02() throws IOException, FileNotFoundException {
		super();
	}

	@Test
	public void lego_test_02() throws Exception {
		HomePage homePage = new HomePage(driver, LEGO_PROPERTIES);
		homePage.acceptTheCookies();
		homePage.searchForProduct("BB-8");
		ProductPreview productPreview = new ProductPreview(driver);
		productPreview.verifyProduct();
		productPreview.addToCart();
	}

}