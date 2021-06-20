package com.lego.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.lego.util.PropertiesUtil;

public class BaseTest {
	
	/* BaseTest is a class that all "Test" classes extend;
	 In before method browser configuration setup;
	 In after method turning off the browser; */

	protected WebDriver driver;
	protected PropertiesUtil lego_properties = null;
	protected final String LEGO_PROPERTIES = "lego.properties";

	public BaseTest() throws IOException, FileNotFoundException {
		lego_properties = new PropertiesUtil(LEGO_PROPERTIES);
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("security.sandbox.content.level", 5);
			profile.setPreference("browser.privatebrowsing.autostart", true);
			profile.setPreference("dom.disable_beforeunload", true);
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("incognito");
			options.addArguments("chrome.switches", "--disable-extensions");
			driver = new ChromeDriver(options);
		} else {
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void cleanUp() {
	driver.quit();
	}
}
