package com.diw.TestListeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Admin on 05-09-2014.
 */
public class TestListener extends TestListenerAdapter {
    WebDriver driver;
    public void onTestFailure(ITestResult result){

        driver=(WebDriver)result.getTestContext().getAttribute("driver_object");
        makeScreenShot(driver);
    }
    public void onTestSkipped(ITestResult result){
        driver=(WebDriver)result.getTestContext().getAttribute("driver_object");
        makeScreenShot(driver);
    }
    public void onTestStart(ITestResult result){

    }
    @Attachment(value = "Screen_Shot",type = "image/png")
    public byte[] makeScreenShot(WebDriver driver) {
        byte[] screen_shot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screen_shot;
    }
    public void screenCapture(WebDriver driver) {
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            long time=System.currentTimeMillis();
            File f1=new File("src/Failed_Scree_Shots/ScreenShot-"+time+".jpg");
            FileUtils.copyFile(f, f1);
            System.setProperty("org.uncommons.reportng.escape-output","false");
            Reporter.log("<a style='background-color:#008080;color:white;font-size: 150%;' href='"+f1.getAbsolutePath()+"'>"+"<img height='50' width='100' src=\""+f1.getAbsolutePath()+"\"/>View Image</a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
