package com.diw.Tracker;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class EventTracker extends AbstractWebDriverEventListener  {
	static Logger log = Logger.getLogger(EventTracker.class);

	@Override
	public void afterNavigateTo(String url, WebDriver driver){
		log.info("use is navigated to:'"+url);    	
	}
	@Override
	public void	afterChangeValueOf(WebElement element, WebDriver driver){
		log.info("Entered the text successfully...on "+element.getTagName().toString().toUpperCase());
	}
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver){
		log.info("Trying to click on the........"+  element.getTagName().toString().toUpperCase()+"........Element successfully ..... ");
	}
	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver){
		log.info("Trying to find: '" +by+ "'.");
	}


	public void afterFindBy(By by, WebElement element, WebDriver driver){
		log.info("Element is Found: '" +by+ "'.");
	}

}
