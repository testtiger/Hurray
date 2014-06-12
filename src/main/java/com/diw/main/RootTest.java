package com.diw.main;

//import com.diw.page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.diw.main.Manager;

import com.diw.page.LoginPage;
import com.diw.page.MyAccount;

public class RootTest {
	private Manager manager;
	private WebDriver driver;

	@BeforeTest
	@Parameters({ "browser", "classname" })
	public void setup(String browser, String classname) {
		try {
			manager = (Manager) Class.forName(classname).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = manager.getDriver(browser);
	}

	@AfterTest
	public void tear() {
		manager.closeDriver(driver);
	}
	public WebDriver getDriver(){
		return driver;
	}
	


}
