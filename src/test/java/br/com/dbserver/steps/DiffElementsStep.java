package br.com.dbserver.steps;

import br.com.dbserver.pageobjects.DiffElementsPageObject;
import br.com.dbserver.utils.ActionsSupport;
import br.com.dbserver.utils.Report;
import br.com.dbserver.webdrivers.DriverClose;
import br.com.dbserver.utils.JavaScriptAlert;
import br.com.dbserver.utils.JsExecutor;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.security.Key;

public class DiffElementsStep {
    private final WebDriver driver;
    private final DiffElementsPageObject diffElements;
    private JsExecutor jsExecutor;
    private Faker faker;
    private ActionsSupport actionsSupport;
    private static final String FILE_UPDATE = System.getProperty("user.dir") + File.separator + "photo" + File.separator + "java.jpg";

    public DiffElementsStep(WebDriver _driver) {
        driver = _driver;
        diffElements = new DiffElementsPageObject(_driver);
        faker = new Faker();
        jsExecutor = new JsExecutor();
        actionsSupport = new ActionsSupport(driver);
    }

    public DiffElementsStep indexPage() {
        textArea();
        textBox();
        radioButton();
        checkBox();
        inputTypeButton();
        image();
        dropDownSelect();
        webTable();
        frameSeleniumAndWikipedia();
        datePicker();
        autoCompleteEmail();
        listBox();
        comboBox();
        doubleClick();
        fileUpdate();
        jsAlertaPopUp();
        clickToOpenNewBrowser();
        clickHoldWait();
        return this;
    }

    private DiffElementsStep textArea() {
        Report.log(Status.INFO, "Text Area");
        String space = "\n";
        String text = "Test String" + space;
        String textFaker = faker.chuckNorris().fact() + space;
        diffElements.textAreatextField().clear();
        diffElements.textAreatextField().sendKeys("Test:" + space);
        diffElements.textAreatextField().sendKeys(text);
        diffElements.textAreatextField().sendKeys(textFaker);
        diffElements.textAreatextField().sendKeys(faker.harryPotter().spell());
        return this;
    }

    private DiffElementsStep textBox() {
        Report.log(Status.INFO, "Text Box");
        String firstNameString = "Test";
        String lastNameString = "NG";
        String firstNameFaker = faker.name().firstName();
        String lastNameFaker = faker.name().lastName();
        //Utilizei string com variáveis.
        diffElements.textBoxFirstNameTextField().sendKeys(firstNameString);
        diffElements.textBoxLastNameTextField().sendKeys(lastNameString);
        diffElements.textBoxResetButton().click();
        //Utilizei string com variáveis e método de faker.
        diffElements.textBoxFirstNameTextField().sendKeys(firstNameFaker);
        diffElements.textBoxLastNameTextField().sendKeys(lastNameFaker);
        diffElements.textBoxResetButton().click();
        //Digitei dentro método de sendKeys com string.
        diffElements.textBoxFirstNameTextField().sendKeys("First Test Keys");
        diffElements.textBoxLastNameTextField().sendKeys("Last Test Keys");
        diffElements.textBoxResetButton().click();
        //Utilizei método de faker.
        diffElements.textBoxFirstNameTextField().sendKeys(faker.name().firstName());
        diffElements.textBoxLastNameTextField().sendKeys(faker.name().lastName());
        diffElements.textBoxResetButton().click();
        return this;
    }

    private DiffElementsStep radioButton() {
        Report.log(Status.INFO, "Radio Button");
        diffElements.radioButtonNoCheckBox().click();
        diffElements.radioButtonYesCheckBox().click();
        diffElements.radioButtonOtherCheckBox().click();
        return this;
    }

    private DiffElementsStep checkBox() {
        Report.log(Status.INFO, "CheckBox");
        diffElements.checkboxOneCheckBox().click();
        diffElements.checkboxTwoCheckBox().click();
        diffElements.checkboxThreeCheckBox().click();
        diffElements.checkboxFourCheckBox().click();
        return this;
    }

    private DiffElementsStep inputTypeButton() {
        Report.log(Status.INFO, "Input Type Button");
        diffElements.inputTypeButtonClickMeButton().click();
        JavaScriptAlert.jsAlertAccept(driver);
        return this;
    }

    private DiffElementsStep image() {
        Report.log(Status.INFO, "Image");
        jsExecutor.ImageFile(driver, diffElements.imageFile());
        return this;
    }

    private DiffElementsStep dropDownSelect() {
        Report.log(Status.INFO, "Drop Down");
        diffElements.dropDownCarsComboBox().selectByValue("saab");
        diffElements.dropDownCarsComboBox().selectByValue("audi");
        diffElements.dropDownCarsComboBox().selectByValue("volvo");
        diffElements.dropDownCarsComboBox().selectByValue("fiat");
        diffElements.submitButton().click();
        DriverClose.closeTab(driver);
        return this;
    }

    private DiffElementsStep webTable() {
        Report.log(Status.INFO, "Web Table");
        Assert.assertEquals(diffElements.webTableNameLabel().getText(), "James");
        Assert.assertEquals(diffElements.webTableJamesSalaryLabel().getText(), "5000");
        Assert.assertEquals(diffElements.webTableNameTwoColunLabel().getText(), "John");
        Assert.assertEquals(diffElements.webTableJohnSalaryLabel().getText(), "7000");
        return this;
    }

    private DiffElementsStep frameSeleniumAndWikipedia() {
        Report.log(Status.INFO, "Frames");
        Assert.assertEquals(diffElements.validateSeleniumWebDriverLabel().getText(), "Selenium WebDriver");
        driver.switchTo().defaultContent();
        diffElements.searchWikipediaTextField().sendKeys("Microsoft Windows");
        driver.switchTo().defaultContent();
        diffElements.searchWikipediaButton().click();
        driver.switchTo().defaultContent();
        return this;
    }

    private DiffElementsStep datePicker() {
        Report.log(Status.INFO, "Date Picker");
        diffElements.datePickerTextField().sendKeys("20112018");
        return this;
    }

    private DiffElementsStep autoCompleteEmail() {
        Report.log(Status.INFO, "Auto Complete");
        String email = "test@test.com";
        String emailFaker = faker.internet().emailAddress();
        // utilizei string com variável.
        diffElements.autoCompleteEmailtextField().sendKeys(email);
        diffElements.autoCompleteEmailtextField().clear();
        // utilizei variável com método de faker.
        diffElements.autoCompleteEmailtextField().sendKeys(emailFaker);
        diffElements.autoCompleteEmailtextField().clear();
        // utilizei string dentro método de sendkey.
        diffElements.autoCompleteEmailtextField().sendKeys("string@string.com");
        diffElements.autoCompleteEmailtextField().clear();
        // utilizei método de faker dentro sendkey.
        diffElements.autoCompleteEmailtextField().sendKeys(faker.internet().emailAddress());
        return this;
    }

    private DiffElementsStep listBox() {
        Report.log(Status.INFO, "List Box");
        diffElements.listBoxComboBox().selectByValue("Option3");
        diffElements.listBoxComboBox().deselectByValue("Option3");
        diffElements.listBoxComboBox().selectByValue("option1");
        diffElements.listBoxComboBox().deselectByValue("option1");
        diffElements.listBoxComboBox().selectByValue("option2");
        diffElements.listBoxComboBox().deselectByValue("option2");
        return this;
    }

    private DiffElementsStep comboBox() {
        Report.log(Status.INFO, "Combo Box");
        diffElements.comboBox().selectByValue("java");
        diffElements.comboBox().selectByValue("C++");
        diffElements.comboBox().selectByValue("html");
        diffElements.comboBox().selectByValue("sap");
        return this;
    }

    private DiffElementsStep doubleClick() {
        Report.log(Status.INFO, "Double Click");
        actionsSupport.doubleClick(diffElements.doubleClickButton());
        JavaScriptAlert.jsAlertAccept(driver);
        return this;
    }

    private DiffElementsStep fileUpdate() {
        Report.log(Status.INFO, "File Update");
        diffElements.fileUpdateButton().sendKeys(FILE_UPDATE);
        return this;
    }

    private DiffElementsStep jsAlertaPopUp() {
        Report.log(Status.INFO, "Alerts Pop-Up");
        diffElements.simpleAlertButton().click();
        JavaScriptAlert.jsAlertAccept(driver);
        diffElements.confirmationAlertButton().click();
        JavaScriptAlert.jsAlertAccept(driver);
        diffElements.confirmationAlertButton().click();
        JavaScriptAlert.jsAlertDismiss(driver);
        diffElements.promptAlertButton().click();
        JavaScriptAlert.jsAlertKeys(driver, "Gooooool!!!!");
        JavaScriptAlert.jsAlertAccept(driver);
        return this;
    }

    private DiffElementsStep clickToOpenNewBrowser() {
        Report.log(Status.INFO, "Click To Open New Browser and close");
        diffElements.clickToOpenNewBrowserButton().click();
        return this;
    }

    private DiffElementsStep clickHoldWait() {
        Report.log(Status.INFO, "Click and Hold");
        diffElements.clickHoldWaitButton().click();
        if (diffElements.validateClickAndHoldLabel().isDisplayed()) {
            System.out.println("Click and hold: " + diffElements.validateClickAndHoldLabel().getText());
            Assert.assertEquals("Welcome To Automation Testing Insider", diffElements.validateClickAndHoldLabel().getText());
        } else {
            System.out.println("Error - click and hold.");
        }
        DriverClose.closeSecondaryBrowser(driver);
        return this;
    }
}