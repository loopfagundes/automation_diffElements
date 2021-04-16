package br.com.dbserver.utils;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsSupport {
    private static Actions actions;

    public ActionsSupport(WebDriver driver) {
        actions = new Actions(driver);
    }

    public static void doubleClick(WebElement elementLocator) {
        actions.doubleClick(elementLocator).perform();
    }

    public static void clickAndHold(WebElement elementLocator) {

    }
}