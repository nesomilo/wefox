package com.facebook.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.facebook.util.HandlerUtil;
import com.facebook.util.PropertiesUtil;

public class PageBase {

	protected HandlerUtil lastBrowserHandler;
	protected WebDriver driver;
	protected PropertiesUtil properties;
	protected PropertiesUtil fb_properties = null;

	protected final String FB_PROPERTIES = "fb.properties";

	public PageBase(WebDriver driver) throws FileNotFoundException, IOException {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		fb_properties = new PropertiesUtil(FB_PROPERTIES);
	}

	protected Select select(WebElement webElement, String name) {
		Select selectedElement = new Select(webElement);
		selectedElement.selectByVisibleText(name);
		return selectedElement;
	}

	public void activateHandler() {
		lastBrowserHandler = new HandlerUtil();
		driver.switchTo().window(lastBrowserHandler.getLastBrowserHandle(driver));
	}

}
