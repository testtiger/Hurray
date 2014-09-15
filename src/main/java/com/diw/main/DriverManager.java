package com.diw.main;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.diw.Tracker.EventTracker;

public class DriverManager implements Manager {
	private static WebDriver driver;
	/**
	 * @param browser_class 
	 * This method takes fully qualified java class name in order to get the required browser object 
	 */
	public WebDriver getDriver(String browser_class) {
		if(driver==null){
			setDriver(browser_class);
		}	
		return driver;
	}
	/*
	 * This method will be called by  @see com.diw.main.Manager#getDriver(java.lang.String) method
	 * & It is responsible to create browser driver object  
	 *
	 */
	public void setDriver(String browser) {
		try {
			driver=(WebDriver)Class.forName(browser).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver=registerEvents(driver);
	}
	/**
	 * @param driver
	 *  This method register the web driver type object & register
	 * with the web driver event listener@see com.diw.Tracker.EventTracker
	 */
	public WebDriver registerEvents(WebDriver driver) {
		EventFiringWebDriver ef = new EventFiringWebDriver(driver);
		driver = ef.register(new EventTracker());
		return driver;
	}

	/**
	 * @param driver
	 * This method kills the created driver object.
	 * 
	 */

	public void closeDriver(WebDriver driver) {
        driver.quit();
	}

}
