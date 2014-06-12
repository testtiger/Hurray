package com.diw.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.diw.action.UserActions;



public class RegistrationPage {
	
	private String firstname_text_field="//input[@id='firstname']";
	private String latsname_text_field="//input[@id='lastname']";
	private String rgstr_email_text_field="//input[@id='email_address']";
	private String pwd_text_field="//input[@id='password']";
	private String cnfrm_pwd_text_field="//input[@id='confirmation']";
	
	private String dob_day_drop_down="//select[@id='day']";
	private String dob_month_drop_down="//select[@id='month']";
	private String dob_year_drop_down="//select[@id='year']";
	private String gender_checkbox="//input[@id='gender_male']"; 
	private String privacy_policy_checkbox="//input[@id='is_subscribed']"; 
	
	private String regstr_button="//span[contains(text(),'Register')]"; 
	
	
	public RegistrationPage(WebDriver driver){
		
	}
	public MyAccount doRegister(WebDriver driver,String...a){
		
		UserActions.Type(driver, By.xpath(firstname_text_field), a[0]);
		UserActions.Type(driver, By.xpath(latsname_text_field), a[1]);
		UserActions.Type(driver, By.xpath(rgstr_email_text_field), a[2]);
		UserActions.Type(driver, By.xpath(pwd_text_field), a[3]);
		UserActions.Type(driver, By.xpath(cnfrm_pwd_text_field), a[4]);
		UserActions.selectOptionFromDropDwon(driver, By.xpath(dob_day_drop_down), 1);
		UserActions.selectOptionFromDropDwon(driver, By.xpath(dob_month_drop_down), 1);
		UserActions.selectOptionFromDropDwon(driver, By.xpath(dob_year_drop_down), 1);
		UserActions.click(driver, By.xpath(gender_checkbox));
		UserActions.click(driver, By.xpath(privacy_policy_checkbox));
		UserActions.click(driver, By.xpath(regstr_button));
		return new MyAccount(driver);
	}
	

}
