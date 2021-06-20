package com.lego.page;

import static org.testng.Assert.assertTrue;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.lego.base.PageBase;

public class FourPlusPage extends PageBase {

	public FourPlusPage(WebDriver driver) throws FileNotFoundException, IOException {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, 10);

	@FindBy(xpath = "//h1")
	private WebElement headerWE;

	@FindBy(xpath = "//div/section/div/div/div[1]/div/div[1]")
	private WebElement pagingWE;

	@FindBy(xpath = "//div[3]/div/div/div/div/ul/li[1]/label/div/div")
	private WebElement priceCheckBoxWE;

	@FindBy(xpath = "//li[1]/div/div[2]/div[2]")
	private WebElement addToMyBagBtnWE;

	@FindBy(xpath = "//div[2]/a")
	private WebElement viewMyBagBtnWE;

	@FindBy(xpath = "//*[contains(@href,'/es-es/product/mickey-mouse-minnie-mouse-s-space-rocket-10774')]")
	private WebElement productInBagWE;

	@FindBy(xpath = "//div/div/div[1]/div[2]/div[2]/div[2]")
	private WebElement priceInBagWE;

	public void verifyAndNavigate() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(headerWE));
		wait.until(ExpectedConditions.visibilityOf(pagingWE));
		assertTrue(headerWE.getText().equals("4+ años"), "Header title is not good!");
		String getText = driver.findElement(By.xpath("//div[3]/div/div/div/div/ul/li[1]/label")).getText();
		String number = (getText.substring(12, 14)); // storing information about number of products in price range
		wait.until(ExpectedConditions.elementToBeClickable(priceCheckBoxWE));
		priceCheckBoxWE.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(text(),'Mostrando 1 - 18 de " + number + " resultados')]")));
		// asserting that the same number is shown in "paging" text
	}

	public void checkPaycheck() {
		String productName = driver.findElement(By.xpath("//li[1]/div/div[2]/div[1]/a")).getText();
		String productPrice = driver.findElement(By.xpath("//li[1]/div/div[2]/div[1]/div[3]")).getText();
		wait.until(ExpectedConditions.elementToBeClickable(addToMyBagBtnWE));
		addToMyBagBtnWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(viewMyBagBtnWE));
		viewMyBagBtnWE.click();
		wait.until(ExpectedConditions.visibilityOf(productInBagWE));
		assertTrue(productInBagWE.getText().equals(productName), "Product name doesn't match!");
		assertTrue(priceInBagWE.getText().equals(productPrice), "Product total price doesn't match!");
	}

}