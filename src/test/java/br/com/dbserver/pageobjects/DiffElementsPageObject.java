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

    public WebElement textAreatextField() {
        return waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > form:nth-child(5) > textarea"));
    }

    public WebElement textBoxFirstNameTextField() {
        return waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > form:nth-child(13) > input[type=text]:nth-child(2)"));
    }

    public WebElement textBoxLastNameTextField() {
        return waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > form:nth-child(13) > input[type=text]:nth-child(5)"));
    }

    public WebElement textBoxResetButton() {
        return waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > form:nth-child(13) > input[type=reset]:nth-child(9)"));
    }
}