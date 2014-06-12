package com.diw.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.diw.action.UserActions;
public class HomePage {


	private static String joinlink="//a[@title='Join']";
	private static String signin_link="//a[@title='Sign In']";
	private static String logo=".logo";

	public HomePage(WebDriver driver){
		

	}

	public static LoginPage clickOnsigninLink(WebDriver driver){
		UserActions.click(driver,By.xpath(signin_link));
		return new LoginPage(driver);
	}

	public static void clikcOnMainCategory(WebDriver driver,String Category){

	}
	public static RegistrationPage clickOnRegistrationLink(WebDriver driver){
		UserActions.click(driver,By.xpath(joinlink));
		return new RegistrationPage(driver);
	}
	public static HomePage clikonLogo(WebDriver driver){
		UserActions.click(driver,By.cssSelector(logo));
		return new HomePage(driver);	
	}
	public static boolean checkHomepageExistence(WebDriver driver){
		if(driver.getCurrentUrl().contentEquals("http://www.routeone.co.uk/")){
			return true;
		}
		else{
			return false;		
		}
	}


}
