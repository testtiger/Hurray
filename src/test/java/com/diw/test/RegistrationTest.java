package com.diw.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.diw.action.UserActions;
import com.diw.main.RootTest;
import com.diw.page.RegistrationPage;

public class RegistrationTest extends RootTest{

	private WebDriver driver;

	@BeforeClass
	public void setDriver(){

		driver=super.getDriver();
	}
	String[] a=new String[]{"mark","B","markb1213@gmail.com","p123456","p123456"};

	@Test(description="")
	public void checkRegistration(){
		driver.get("https://www.routeone.co.uk/customer/account/create/");

		RegistrationPage.doRegister(driver,a);
		String xx=UserActions.getText(driver,By.xpath("//span[text()='My Account']"));
		if(xx!=null){
			Assert.assertTrue(xx.equalsIgnoreCase("My Account"));
		}
		else{
			Assert.assertTrue(false);
		}

	}

	/*	@DataProvider(name = "create")
	public Iterator<Object[]> createData() {
		List<Object[]> data = new ArrayList<Object[]>();
		data.add(new Object[] { "mark"});
		data.add(new Object[] { "B"});
		data.add(new Object[] { "markb123@gmail.com" });
		data.add(new Object[] { "p123456"});
		data.add(new Object[] { "p123456"});
		return data.iterator();
		//	return new Object[][] { new Object[] { "Cedric" }};

	}
	 */
}
