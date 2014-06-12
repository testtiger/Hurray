package com.diw.main;

import org.openqa.selenium.WebDriver;

public interface Manager {
	WebDriver getDriver(String browser_name);

	void setDriver(String browser);

	void closeDriver(WebDriver driver);
}
