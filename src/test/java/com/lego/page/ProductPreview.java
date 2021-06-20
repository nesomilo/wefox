package com.lego.page;

import static org.testng.Assert.assertTrue;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.lego.base.PageBase;

public class ProductPreview extends PageBase {

	public ProductPreview(WebDriver driver) throws FileNotFoundException, IOException {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, 10);

	@FindBy(xpath = "//h1")
	private WebElement productNameWE;
	
	@FindBy(xpath = "//ol/li[3]")
	private WebElement productPathWE;
	
	@FindBy(xpath = "//*[@type='submit' and @data-test='add-to-bag']")
	private WebElement addToCartBtnWE;
	
	@FindBy(xpath = "//div[2]/div[2]/div[2]/a")
	private WebElement viewCartBtnWE;
	
	@FindBy(xpath = "//*[contains(@href,'/es-es/product/lego-star-wars-bb-8-led-keyring-torch-5005298')]")
	private WebElement productInCartWE;

	public void verifyProduct() {
		wait.until(ExpectedConditions.visibilityOf(productNameWE));
		assertTrue(productNameWE.getText().contains("Llavero con linterna de BB-8™ LEGO® "), "Product name is not displayed well!");
		assertTrue(productPathWE.getText().contains("Llavero con linterna de BB-8™ LEGO® "), "Product name is not displayed well!");
	}
	
	public void addToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtnWE));
		addToCartBtnWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(viewCartBtnWE));
		viewCartBtnWE.click();
		wait.until(ExpectedConditions.visibilityOf(productInCartWE));
	}

}