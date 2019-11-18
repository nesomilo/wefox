package com.facebook.page;

import static org.testng.Assert.assertTrue;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.facebook.util.HelperUtil;
import com.facebook.base.PageBase;

public class LoginFacebook extends PageBase {

	@FindBy(xpath = "//td[1]/input")
	protected WebElement logInEmailWE;

	@FindBy(xpath = "//td[2]/input")
	protected WebElement logInPasswordWE;

	@FindBy(xpath = "//label/input")
	protected WebElement logInBtnWE;

	@FindBy(xpath = "//div[5]/a")
	protected WebElement createNewAccountBtnWE;

	@FindBy(xpath = "//div[1]/div[1]/div[1]/div[1]/div/div[1]/input")
	protected WebElement firstNameWE;

	@FindBy(xpath = "//div[1]/div[1]/div[2]/div/div[1]/input")
	protected WebElement lastNameWE;

	@FindBy(xpath = "//form/div[1]/div[2]/div/div[1]/input")
	protected WebElement emailWE;

	@FindBy(xpath = "//div[3]/div/div/div[1]/input")
	protected WebElement confirmEmailWE;

	@FindBy(xpath = "//div[4]/div/div[1]/input")
	protected WebElement passwordWE;

	@FindBy(xpath = "//span[2]/input")
	protected WebElement maleRBtnWE;

	@FindBy(xpath = "//div[9]/button")
	protected WebElement signUpBtnWE;
	
	@FindBy(xpath = "//div[17]/button")
	protected WebElement noNameMessageWE;
	
	@FindBy(xpath = "//div[18]/button")
	protected WebElement noLastNameMessageWE;
	
	@FindBy(xpath = "//div[19]/button")
	protected WebElement noEmailAddressMessageWE;
	
	@FindBy(xpath = "//div[20]/button")
	protected WebElement noPasswordMessageWE;


	public LoginFacebook(WebDriver driver) throws FileNotFoundException, IOException {
		super(driver);
		driver.get(fb_properties.getValue("URL.LOGIN"));
	}
	
	
	public void enterLogInData(String email) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String emailAddress = HelperUtil.getRandomEmail1Address(email);
		wait.until(ExpectedConditions.elementToBeClickable(logInEmailWE));
		logInEmailWE.clear();
		logInEmailWE.sendKeys(emailAddress);
		wait.until(ExpectedConditions.elementToBeClickable(logInPasswordWE));
		logInPasswordWE.clear();
		logInPasswordWE.sendKeys("Pa$$w0rd");
		logInBtnWE.click();
	}

	public void enterSignUpData() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String firstName = HelperUtil.getRandomFirstName();
		String lastName = HelperUtil.getRandomLastName();
		String emailAddress = HelperUtil.getRandomEmailAddress();
		wait.until(ExpectedConditions.elementToBeClickable(firstNameWE));
		firstNameWE.clear();
		firstNameWE.sendKeys(firstName);
		lastNameWE.clear();
		lastNameWE.sendKeys(lastName);
		emailWE.sendKeys(emailAddress);
		confirmEmailWE.sendKeys(emailAddress);
		maleRBtnWE.click();
		passwordWE.sendKeys("Pa$$w0rd");
		signUpBtnWE.click();
//		 naredni koraci prilikom pravljenja account-a:
//		 1. confirmation code on email
//		 2. captcha confirmation (I'm not a robot)
//		 3. enter code that is sent to mobile phone
	}
	
	public void enterCustomSignUpData(String firstName, String lastName, String emailAddress, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(firstNameWE));
		firstNameWE.clear();
		firstNameWE.sendKeys(firstName);
		lastNameWE.clear();
		lastNameWE.sendKeys(lastName);
		emailWE.sendKeys(emailAddress);
		confirmEmailWE.sendKeys(emailAddress);
		maleRBtnWE.click();
		passwordWE.sendKeys(password);
		signUpBtnWE.click();
	}
	
	public void verifyValidationMessages(String firstName, String lastName, String emailAddress, String password) throws InterruptedException {
		
		enterCustomSignUpData(firstName, lastName, emailAddress, password);
		if (firstName.equals("")) {
			assertTrue(noNameMessageWE.getText().equals("First name can not be empty."),
					"Message is not good.");
		}
		if (lastName.equals("")) {
			assertTrue(noLastNameMessageWE.getText().equals("Last name can not be empty."),
					"Message is not good.");
		}
		if (emailAddress.equals("")) {
			assertTrue(noEmailAddressMessageWE.getText().equals("Email can not be empty."), "Message is not good.");
		}
		if (password.equals("")) {
			assertTrue(noPasswordMessageWE.getText().equals("Password can not be empty."), "Message is not good.");
		}
	}

}