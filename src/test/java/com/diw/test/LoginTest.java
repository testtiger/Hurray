package com.diw.test;

//import com.diw.page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;

import com.diw.main.Manager;
import com.diw.main.RootTest;
import com.diw.page.LoginPage;
import com.diw.page.MyAccount;

public class LoginTest extends RootTest{

	private WebDriver driver;
	private static String url = "http://www.routeone.co.uk/";

	@BeforeClass
	public void setDriver(){
		driver=super.getDriver();
		driver.get(url);
	
	}

	@Parameters({ "email", "pwd" })
	@Step("Enter user name,pwd and click on sigin btn & verify the signin ")
	@Test
	public void checkUserLogin(String email_id, String pwd) {

		LoginPage.doLogin(this.driver, email_id, pwd);
		Assert.assertTrue(driver.getTitle().contains("My Account"));
	}
	@Step("Click on Log out link in the Header ")
	@Test
	public void checkUserLogout() {
		MyAccount.doLogout(driver);
		Assert.assertTrue(driver.findElement(
				By.xpath("//h1[contains(text(),'You are now logged out')]"))
				.isDisplayed());
	}





	/*
	 * @Test public void checklogoLink(){
	 * //Assert.assertTrue(LoginPage.clikonLogo
	 * (driver).checkHomepageExistence(driver)); }
	 */

	/*
	 * @Test public void checklink(){ HomePage.clickOnsigninLink(driver); }
	 */
}
