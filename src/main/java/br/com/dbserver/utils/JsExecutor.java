package br.com.dbserver.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsExecutor {

    public static void ImageFile(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Boolean imagePresent = (Boolean) jse.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
        try {
            if (imagePresent) {
                System.out.println("Image is displayed");
            } else {
                System.out.println("Image not displayed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}