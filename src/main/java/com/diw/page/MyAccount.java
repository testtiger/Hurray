package com.diw.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.diw.action.UserActions;

public class MyAccount {
	
	private static String sign_out_link="//a[@title='Sign Out']";
	private static String text_after_signout="//h1[contains(text(),'You are now logged out')]";
	
	public MyAccount(WebDriver driver){
		
	}
	public static void doLogout(WebDriver driver){
		
		UserActions.click(driver,By.xpath(sign_out_link));
	}

}
