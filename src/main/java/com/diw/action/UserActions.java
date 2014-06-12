package com.diw.action;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


import com.google.common.base.Function;

import  java.util.concurrent.TimeUnit;

public class UserActions {

	public static Logger log = Logger.getLogger(UserActions.class.getName());

	public static WebElement getWebElement(WebDriver driver, final By locator){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		log.info("element is located "+element.toString());
		return element;
	}

	public static void click(WebDriver driver,By locator ){
		try{
			WebElement element=UserActions.getWebElement(driver, locator);
			element.click();
			log.info("element is cliked "+element.toString());

		}
		catch(Exception e){
			log.error("Failed to click !! locator details are"+locator+"Exception stack trace is:"+e);	
		}
	}
	public static void Type(WebDriver driver,By locator,String texttotype){	
		try{
			WebElement element=UserActions.getWebElement(driver, locator);
			element.sendKeys(texttotype);
			log.info("element is cliked "+element.toString());
		}
		catch(Exception e){
			log.error("Failed to Type !! locator details are"+locator+"Exception stack tarce is:"+e);	
		}
	}	
	public static String getText(WebDriver driver,By locator){	
		WebElement we=null;
		try{
			we=UserActions.getWebElement(driver, locator);
		}
		catch(Exception e){
			log.error("Failed to Type !! locator details are"+locator+"Exception stack tarce is:"+e);	
		}
		return we.getText();
		
	}
	public static void selectOptionFromDropDwon(WebDriver driver,By locator,int index){	
		try{
			Select select = new Select(UserActions.getWebElement(driver, locator));
			select.selectByIndex(index);
		}
		catch(Exception e){
			log.error("Failed to Select !! locator details are"+locator+"Exception stack tarce is:"+e);	
		}
	}

}
