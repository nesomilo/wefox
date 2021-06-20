package com.lego.page;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lego.base.PageBase;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver, String URL) throws FileNotFoundException, IOException, InterruptedException {
		super(driver);
		URL = lego_properties.getValue("URL");
		driver.get(URL);
	}

	WebDriverWait wait = new WebDriverWait(driver, 10);

	@FindBy(xpath = "//*[contains(text(),'Continuar') and @type='submit' and @class='Button__Base-sc-1jdmsyi-0 eLFkVi AgeGatestyles__StyledButton-xudtvj-10 cDAvju']")
	private WebElement continueWE;

	@FindBy(xpath = "//*[contains(text(),'Aceptar todo') and @type='submit']")
	private WebElement acceptCookiesWE;

	@FindBy(xpath = "//li[2]/button")
	private WebElement shopByWE;

	@FindBy(xpath = "//div[1]/button[3]")
	private WebElement ageWE;

	@FindBy(xpath = "//li[2]/div/div/div[2]/ul/li[2]/a")
	private WebElement fourPlusAgeWE;

	public void acceptTheCookies() {
		wait.until(ExpectedConditions.elementToBeClickable(continueWE));
		continueWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesWE));
		acceptCookiesWE.click();
	}

	public void navigateOnProduct() {
		wait.until(ExpectedConditions.elementToBeClickable(shopByWE));
		shopByWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(ageWE));
		ageWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(fourPlusAgeWE));
		fourPlusAgeWE.click();
	}

	public void searchForProduct(String product) {
		wait.until(ExpectedConditions.elementToBeClickable(searchWE));
		searchWE.sendKeys(product);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Llavero con linterna de " + product + "')]"))).click();

	}

}