package com.diw.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.diw.action.UserActions;



public class RegistrationPage {
	
	private static String firstname_text_field="//input[@id='firstname']";
	private static String latsname_text_field="//input[@id='lastname']";
	private static String rgstr_email_text_field="//input[@id='email_address']";
	private static String pwd_text_field="//input[@id='password']";
	private static String cnfrm_pwd_text_field="//input[@id='confirmation']";
	private static String dob_day_drop_down="//select[@id='day']";
	private static String dob_month_drop_down="//select[@id='month']";
	private static String dob_year_drop_down="//select[@id='year']";
	private static String gender_checkbox="//input[@id='gender_male']"; 
	private static String privacy_policy_checkbox="//input[@id='is_subscribed']"; 
	private static String regstr_button="//span[contains(text(),'Register')]"; 
	
	private static String register_page="Account Set Up";
	public RegistrationPage(WebDriver driver){

	}
	public static MyAccount  doRegister(WebDriver driver,String...a){
		
		UserActions.Type(driver, By.xpath(firstname_text_field), a[0]);
		UserActions.Type(driver, By.xpath(latsname_text_field), a[1]);
		UserActions.Type(driver, By.xpath(rgstr_email_text_field), a[2]);
		UserActions.Type(driver, By.xpath(pwd_text_field), a[3]);
		UserActions.Type(driver, By.xpath(cnfrm_pwd_text_field), a[4]);
		UserActions.selectOptionFromDropDown(driver, By.xpath(dob_day_drop_down), 1);
		UserActions.selectOptionFromDropDown(driver, By.xpath(dob_month_drop_down), 1);
		UserActions.selectOptionFromDropDown(driver, By.xpath(dob_year_drop_down), 1);
		UserActions.click(driver, By.xpath(gender_checkbox));
		UserActions.click(driver, By.xpath(privacy_policy_checkbox));
		UserActions.click(driver, By.xpath(regstr_button));
		return new MyAccount(driver);
	}
	

}
