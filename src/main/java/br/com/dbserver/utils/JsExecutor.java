package br.com.dbserver.utils;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsExecutor {

    public static void ImageFile(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Boolean imagePresent = (Boolean) jse.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
        try {
            if (imagePresent) {
                ExtentTestManager.getTest().log(Status.PASS,"Image is displayed");
            } else {
                ExtentTestManager.getTest().log(Status.FAIL,"Image not displayed", Screenshot.capture());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}