package com.diw.Tracker;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class EventTracker extends AbstractWebDriverEventListener{
	static Logger log = Logger.getLogger(EventTracker.class);

	public void afterNavigateTo(String url, WebDriver driver){
		log.info("use is navigated to:'"+url);    	
	}


	public void onException(Throwable throwable, WebDriver driver) {
		
		log.error("Exception was triggered"+throwable);
		
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			long time=System.currentTimeMillis();
			FileUtils.copyFile(f, new File("src/Failed_Scree_Shots/ScreenShot-"+time+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
