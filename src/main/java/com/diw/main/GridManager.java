package com.diw.main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.diw.Tracker.EventTracker;

public class GridManager implements Manager {
	private static WebDriver firefox_driver;
	private static WebDriver chrome_driver;
	private static WebDriver ie_driver;
	private DesiredCapabilities caps;
	private static String hub_URL;


	public WebDriver getDriver(String browser) {
		try{
			if(browser.equalsIgnoreCase("firefox")){
				return setFirefoxDriver();
			}else if(browser.equalsIgnoreCase("chrome")){
				return setChromeDriver();
			}else if(browser.equalsIgnoreCase("ie")){
				return setIEDriver();
			}
		}
		catch(Exception e){
		
		}
		return null;
	}

	@BeforeSuite
	@Parameters({ "huburl" })
	public void setHubURL(String url) {
		hub_URL = url;
	}


	public void setDriver(String bname) {

	}

	public WebDriver registerEvents(WebDriver driver) {
		EventFiringWebDriver ef = new EventFiringWebDriver(driver);
		driver = ef.register(new EventTracker());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	public  WebDriver setFirefoxDriver() throws MalformedURLException{
		if(firefox_driver==null){
			caps = DesiredCapabilities.firefox();
			firefox_driver=new RemoteWebDriver(new URL(hub_URL), caps);
			firefox_driver=registerEvents(firefox_driver);
		}
		return firefox_driver;
	}
	public WebDriver setChromeDriver() throws MalformedURLException{
		if(chrome_driver==null){
			caps = DesiredCapabilities.chrome();
			//caps.setCapability("platform", "Windows 7");
			chrome_driver=new RemoteWebDriver(new URL(hub_URL), caps);
			chrome_driver=registerEvents(chrome_driver);
		}
		return chrome_driver;

	}
	public  WebDriver setIEDriver() throws MalformedURLException {
		if(ie_driver==null){
			caps =DesiredCapabilities.internetExplorer();
			ie_driver=new RemoteWebDriver(new URL(hub_URL), caps);
			ie_driver=registerEvents(ie_driver);
		}
		return ie_driver;
	}

	public void closeDriver(WebDriver driver) {
		driver.quit();
	}
}
