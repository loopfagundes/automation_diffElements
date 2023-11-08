package br.com.dbserver.webdrivers;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class DriverClose {

    public static void closeSecondaryBrowser(WebDriver driver) {
        String firstBrowser = driver.getWindowHandle();
        for (String secondaryBrowser : driver.getWindowHandles()) {
            driver.switchTo().window(secondaryBrowser);
        }
        driver.close();
        driver.switchTo().window(firstBrowser);
    }

    public static void closeTab(WebDriver driver) {
        String originalHandle = driver.getWindowHandle();
        for(String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(originalHandle);
    }

    public static void closeAllTabs(WebDriver driver) {
        Set<String> allTabs = driver.getWindowHandles();
        Iterator<String> interatorTab = allTabs.iterator();
        String[] tabNames = new String[allTabs.size()];
        int i = 0;
        while (interatorTab.hasNext()) {
            tabNames[0] = interatorTab.next();
            i++;
        }
        if (tabNames.length > 1) {
            for (i = tabNames.length; i > 1; i--) {
                driver.switchTo().window(tabNames[i - 1]);
                driver.close();
            }
        }
        driver.switchTo().window(tabNames[0]);
    }
}