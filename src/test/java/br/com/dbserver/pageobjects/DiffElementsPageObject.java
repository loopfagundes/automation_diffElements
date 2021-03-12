package br.com.dbserver.pageobjects;

import br.com.dbserver.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public WebElement radioButtonNoCheckBox() {
        return waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > input[type=radio]:nth-child(22)"));
    }

    public WebElement radioButtonYesCheckBox() {
        return waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > input[type=radio]:nth-child(20)"));
    }

    public WebElement radioButtonOtherCheckBox() {
        return waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > input[type=radio]:nth-child(24)"));
    }

    public WebElement checkboxOneCheckBox() {
        return waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > input[type=checkbox]:nth-child(30)"));
    }

    public WebElement checkboxTwoCheckBox() {
        return waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > input[type=checkbox]:nth-child(32)"));
    }

    public WebElement checkboxThreeCheckBox() {
        return waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > input[type=checkbox]:nth-child(34)"));
    }

    public WebElement checkboxFourCheckBox() {
        return waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > input[type=checkbox]:nth-child(36)"));
    }

    public WebElement inputTypeButtonClickMeButton() {
        return waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > input[type=button]:nth-child(40)"));
    }

    public WebElement imageFile() {
        return waitElement.visibilityOf(By.xpath("//*[@id=\"post-body-7988417473080013803\"]/div[1]/center/img"));
    }

    public Select dropDownCarsComboBox() {
        return new Select(waitElement.toBeClickable(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > form:nth-child(52) > select")));
    }

    public WebElement webTableNameLabel() {
        return waitElement.visibilityOf(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > table > tbody > tr:nth-child(2) > td:nth-child(1)"));
    }

    public WebElement webTableJamesSalaryLabel() {
        return waitElement.visibilityOf(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > table > tbody > tr:nth-child(2) > td:nth-child(2)"));
    }

    public WebElement webTableNameTwoColunLabel() {
        return waitElement.visibilityOf(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > table > tbody > tr:nth-child(3) > td:nth-child(1)"));
    }

    public WebElement webTableJohnSalaryLabel() {
        return waitElement.visibilityOf(By.cssSelector("#post-body-7988417473080013803 > div:nth-child(1) > center > table > tbody > tr:nth-child(3) > td:nth-child(2)"));
    }
}