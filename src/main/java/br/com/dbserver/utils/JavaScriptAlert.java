package br.com.dbserver.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlert {
    private static Alert alert;

    public static void jsAlerts(WebDriver driver) {
        alert = driver.switchTo().alert();
    }

    public static String jsAlertText() {
        String getText = alert.getText();
        return getText;
    }

    public static void jsAlertAccept() {
        alert.accept();
    }

    public static void jsAlertDismiss() {
        alert.dismiss();
    }

    public static void jsAlertKeys(String var) {
        alert.sendKeys(var);
    }
}