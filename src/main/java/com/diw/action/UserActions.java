package com.diw.action;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import com.google.common.base.Function;

import  java.util.concurrent.TimeUnit;


public class UserActions {

	public static Logger log = Logger.getLogger(UserActions.class.getName());
	public static final int STALENESS_MAX_RETRY_COUNT=2;
	static int stale_count=1;
	private static final String getLocatorDetails(By locator){
		String[] tokens=locator.toString().split(":");
		return tokens[tokens.length-1].trim();
	}
	public static void highlightElement(WebDriver driver, WebElement element){
		JavascriptExecutor js= (JavascriptExecutor) driver;;
		for (int i = 0; i < 5; i++){
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 6px solid Coral;");
		}
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
	}
	public static void waitForPageLoad(WebDriver driver){
		while(true){
			String page_status =(String)((JavascriptExecutor)driver).executeScript("return document.readyState");
			log.info("Loading........".toUpperCase());
			if(page_status.equals("complete")){
				break;
			}
		}
	}
	public static WebElement getWebElement(WebDriver driver, final By locator){
		WebElement element=null;
		
		try{
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(50, TimeUnit.SECONDS)
			.pollingEvery(5, TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class);

			element= wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(locator);
				}
			});
			waitForPageLoad(driver);
			while(element.isDisplayed()==false){
			}
			//highlightElement(driver, element);
		}
		catch(TimeoutException we){
			log.error("Failed to retrieve the element within the time out!! locator details are"+getLocatorDetails(locator));
			log.error("stack trace is"+we);
			assert false:"Time out exception is occurred";

		}
		catch(InvalidSelectorException ie){
			log.error("invalid xpath/css");
			assert false:"InvalidSelector Exception is occurred";

		}
		catch(NoSuchElementException we){
			log.error("Failed to retrieve the element, check the xpath/css selector!! locator details are"+getLocatorDetails(locator));
			log.error("stack trace is"+we);
			assert false:"WebDriver exception is occurred";

		}
		catch(StaleElementReferenceException se){
			if(stale_count<=STALENESS_MAX_RETRY_COUNT){
				log.info("Staleness is observed and rrtying ");
				getWebElement(driver,  locator);
				stale_count++;
			}else{
				log.error("Stale element exception is occurred!!!!");
				log.error("Stack trace is"+se);
			}
		}

		catch(WebDriverException we){
			log.error("WebDriver exception is occurred"+we);
			log.error("stack trace is"+we);
			assert false:"NoSuchElement Exception is occurred";

		}

		catch(Exception e){
			log.error("Failed to retrieve the element!! locator details are"+getLocatorDetails(locator));
			log.error("Exception stack trace is:"+e);
			assert false:"Other Exception is occurred";

		}
		finally{
			stale_count=1;
		}
		return element;

	}
	public static void click(WebDriver driver,By locator ){
		log.info("Trying perform click operation on element..... ");
		WebElement element=UserActions.getWebElement(driver, locator);
		element.click();
		log.info("Element is successfully clicked..... ");
	}
	public static void submit(WebDriver driver,By locator ){
		log.info("Trying submit form ..... ");
		WebElement element=UserActions.getWebElement(driver, locator);
		element.submit();
		log.info("Form is successfully submitted..... ");
	}
	public static void Type(WebDriver driver,By locator,String text_to_type){
		log.info("Trying to enter the text following text ..... "+text_to_type);
		WebElement element=UserActions.getWebElement(driver, locator);
		element.sendKeys(text_to_type);
		log.info("Typed the text successfully... ");
	}
	public static String getText(WebDriver driver,By locator){
		log.info("Trying retrieve Text present in the element..... ");
		WebElement element= UserActions.getWebElement(driver, locator);
		return element.getText();
	}

	public static void selectOptionFromDropDown(WebDriver driver,By locator,int index){
		try{
			WebElement element=UserActions.getWebElement(driver, locator);
			Select dropdown = new Select(element);
			dropdown.selectByIndex(index);
		}
		catch(Exception e){
			log.error("Failed to Select !! locator details are"+locator+"Exception stack trace is:"+e);
		}
	}

	public static void waitForExpectedElementVisibility(WebDriver driver, By locator){
		Wait<WebDriver> wait = new WebDriverWait(driver,50);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			log.info("Element is now visible!! "+locator.toString());
		}
		catch(WebDriverException we){
			log.info("Element is not visible within the Timeout!!!  "+locator.toString());
		}
	}

	public static void waitForExpectedElementPresence(WebDriver driver, By locator){
		Wait<WebDriver> wait = new WebDriverWait(driver,50);
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.);
			log.info("Element is now present!! "+locator.toString());
		}
		catch(WebDriverException we){
			log.info("Element is not visible within the Timeout!!!  "+locator.toString());
		}

	}

}
