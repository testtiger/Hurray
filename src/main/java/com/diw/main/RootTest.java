package com.diw.main;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class RootTest {
	private Manager manager;
	private WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser", "classname"})
	public void setup(String browser, String classname) {
		try {
			manager = (Manager) Class.forName(classname).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = manager.getDriver(browser);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@BeforeClass
	public void store(ITestContext context){
		context.setAttribute("driver_object",driver);
	}
	/**
	 * @param chrome_driver_path
	 * @param ie_driver_path
	 * This method will set the Chrome driver & IE driver executables files
	 *  in the system properties
	 */
	@BeforeSuite
	@Parameters({"chrome-driver-path", "ie-driver-path"})
	public void setupChromeAndIEDriverProps(String chrome_driver_path, String ie_driver_path) {
		deleteExistingScreenShots();
		System.setProperty("webdriver.chrome.driver", chrome_driver_path);
		System.setProperty("webdriver.ie.driver", ie_driver_path);
	}
	@AfterSuite
	public void tear() {
		manager.closeDriver(driver);
	}

	/**
	 * 
	 */
	public void deleteExistingScreenShots() {
		File scree_shots_directory = new File("src\\Failed_Scree_Shots");
		if (scree_shots_directory.exists()) {
			if (scree_shots_directory.list().length == 0) {
				scree_shots_directory.delete();
			} else {
				String inner_files[] = scree_shots_directory.list();
				for (String temp : inner_files) {
					new File(scree_shots_directory, temp).delete();
				}
				scree_shots_directory.delete();
			}
		}
	}
}