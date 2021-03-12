package br.com.dbserver.steps;

import br.com.dbserver.pageobjects.DiffElementsPageObject;
import br.com.dbserver.utils.JavaScriptAlert;
import br.com.dbserver.utils.JsExecutor;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DiffElementsStep {
    private final WebDriver driver;
    private final DiffElementsPageObject diffElements;
    private final JavaScriptAlert javaScriptAlert;
    private JsExecutor jsExecutor;
    private Faker faker;

    public DiffElementsStep(WebDriver _driver) {
        driver = _driver;
        diffElements = new DiffElementsPageObject(_driver);
        faker = new Faker();
        javaScriptAlert = new JavaScriptAlert();
        jsExecutor = new JsExecutor();
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
        return this;
    }

    private DiffElementsStep textArea() {
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
        String firstNameString = "Test";
        String lastNameString = "NG";
        String firstNameFaker = faker.name().firstName();
        String lastNameFaker = faker.name().lastName();
        //Utilizei string com variáveis.
        diffElements.textBoxFirstNameTextField().sendKeys(firstNameString);
        diffElements.textBoxLastNameTextField().sendKeys(lastNameString);
        diffElements.textBoxResetButton().click();
        //Utilizei string com variáveis e metodo de faker.
        diffElements.textBoxFirstNameTextField().sendKeys(firstNameFaker);
        diffElements.textBoxLastNameTextField().sendKeys(lastNameFaker);
        diffElements.textBoxResetButton().click();
        //Digitei dentro metodo de sendKeys.
        diffElements.textBoxFirstNameTextField().sendKeys("First Test Keys");
        diffElements.textBoxLastNameTextField().sendKeys("Last Test Keys");
        diffElements.textBoxResetButton().click();
        //Utilizei metodo de faker.
        diffElements.textBoxFirstNameTextField().sendKeys(faker.name().firstName());
        diffElements.textBoxLastNameTextField().sendKeys(faker.name().lastName());
        diffElements.textBoxResetButton().click();
        return this;
    }

    private DiffElementsStep radioButton() {
        diffElements.radioButtonNoCheckBox().click();
        diffElements.radioButtonYesCheckBox().click();
        diffElements.radioButtonOtherCheckBox().click();
        return this;
    }

    private DiffElementsStep checkBox() {
        diffElements.checkboxOneCheckBox().click();
        diffElements.checkboxTwoCheckBox().click();
        diffElements.checkboxThreeCheckBox().click();
        diffElements.checkboxFourCheckBox().click();
        return this;
    }

    private DiffElementsStep inputTypeButton() {
        diffElements.inputTypeButtonClickMeButton().click();
        javaScriptAlert.jsAlerts(driver);
        javaScriptAlert.jsAlertAccept();
        return this;
    }

    private DiffElementsStep image() {
        jsExecutor.ImageFile(driver, diffElements.imageFile());
        return this;
    }

    private DiffElementsStep dropDownSelect() {
        diffElements.dropDownCarsComboBox().selectByValue("saab");
        return this;
    }

    private DiffElementsStep webTable() {
        Assert.assertEquals(diffElements.webTableNameLabel().getText(), "James");
        Assert.assertEquals(diffElements.webTableJamesSalaryLabel().getText(), "5000");
        Assert.assertEquals(diffElements.webTableNameTwoColunLabel().getText(), "John");
        Assert.assertEquals(diffElements.webTableJohnSalaryLabel().getText(), "7000");
        return this;
    }
}