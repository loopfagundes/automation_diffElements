package br.com.dbserver.pageobjects;

import br.com.dbserver.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiffElementsPageObject {
    private final WebDriver driver;
    private final WaitElement waitElement;

    public DiffElementsPageObject(WebDriver _driver) {
        driver = _driver;
        waitElement = new WaitElement(_driver);
    }

    public WebElement getElementsType() {
        return waitElement.toBeClickable(By.id(""));
    }
}