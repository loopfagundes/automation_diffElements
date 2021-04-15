package br.com.dbserver.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlert {
    private static Alert alert;

    public static String jsAlertText(WebDriver driver) {
        alert = driver.switchTo().alert();
        String getText = alert.getText();
        return getText;
    }

    public static Alert jsAlertAccept(WebDriver driver) {
        alert = driver.switchTo().alert();
        alert.accept();
        return alert;
    }

    public static Alert jsAlertDismiss(WebDriver driver) {
        alert = driver.switchTo().alert();
        alert.dismiss();
        return alert;
    }

    public static Alert jsAlertKeys(WebDriver driver, String var) {
        alert = driver.switchTo().alert();
        alert.sendKeys(var);
        return alert;
    }
}