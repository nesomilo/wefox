package com.lego.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.lego.util.HandlerUtil;
import com.lego.util.PropertiesUtil;

public class PageBase {

	// Class that all "Page" classes extend, storing common data

	protected HandlerUtil lastBrowserHandler;
	protected WebDriver driver;
	protected PropertiesUtil properties;
	protected PropertiesUtil lego_properties = null;
	protected final String LEGO_PROPERTIES = "lego.properties";
	
	@FindBy(xpath = "//*[@id='desktop-search-search-input']")
	protected WebElement searchWE;

	public PageBase(WebDriver driver) throws FileNotFoundException, IOException {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		lego_properties = new PropertiesUtil(LEGO_PROPERTIES);
	}

}