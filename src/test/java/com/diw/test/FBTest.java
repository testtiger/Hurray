package com.diw.test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.diw.main.RootTest;

public class FBTest extends RootTest{
	

	private WebDriver driver;
	private static String url = "http://www.fb.com/";

	@BeforeClass
	public void setDriver(){
		driver=super.getDriver();
		driver.get(url);
		Object a = "one";
		List<Object> x=Arrays.asList(a);
	
	}
	

}
