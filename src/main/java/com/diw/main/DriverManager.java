package com.diw.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.diw.Tracker.EventTracker;

public class DriverManager implements Manager {
	private WebDriver driver;

	@Override
	public WebDriver getDriver(String browser_name) {
		if(driver==null){
			setDriver(browser_name);
		}	
		return driver;
	}

	@Override
	public void setDriver(String browser) {
		try {
			driver = (WebDriver) Class.forName(browser).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver=registerEvents(driver);
	}

	/**
	 * @param driver
	 *            This method register the web driver type object & register
	 *            with the web driver event listeners
	 */
	public WebDriver registerEvents(WebDriver driver) {
		EventFiringWebDriver ef = new EventFiringWebDriver(driver);
		driver = ef.register(new EventTracker());
		return driver;
	}

	/**
	 * @param chrome_driver_path
	 * @param ie_driver_path
	 *            This method will set the Chrome driver & IE driver executables
	 *            in the system properties
	 */
	@BeforeSuite
	@Parameters({ "chrome-driver-path", "ie-driver-path" })
	public void setupChromeAndIEDriverProps(String chrome_driver_path,
			String ie_driver_path) {
		System.setProperty("webdriver.chrome.driver", chrome_driver_path);
		System.setProperty("webdriver.ie.driver", ie_driver_path);
	}

	/**
	 * This method Closes the created driver object.
	 * 
	 */

	public void closeDriver(WebDriver driver) {
		driver.quit();
	}

}
