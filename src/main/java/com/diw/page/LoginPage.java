package com.diw.page;
import com.diw.action.UserActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private static String email="//input[@id='email']";
	private static String pwd="//input[@type='password']";
	private static String sign_in="//button[@id='send2']";
	private static String Loinpage_id="//h1[contains(text(),'Sign In')]";
	private static String logo=".logo";

	public LoginPage(WebDriver driver){

	}
	
	public static  MyAccount doLogin(WebDriver driver,String email_id,String password){
		HomePage.clickOnsigninLink(driver);
		UserActions.Type(driver, By.xpath(email),email_id);
		UserActions.Type(driver, By.xpath(pwd),password);
		UserActions.click(driver, By.xpath(sign_in));
		return new MyAccount(driver);
	}

	public static boolean checkLoginpageExistence(WebDriver driver){
		String txt=UserActions.getText(driver,By.xpath(Loinpage_id));
		if(txt.contains("signin")){
			return true;
		}
		else{
			return false;		
		}
	}
	public static HomePage clikonLogo(WebDriver driver){
		UserActions.click(driver,By.cssSelector(logo));
		return new HomePage(driver);	
	}

}
