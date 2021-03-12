package br.com.dbserver.steps;

import br.com.dbserver.pageobjects.DiffElementsPageObject;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

public class DiffElementsStep {
    private final WebDriver driver;
    private final DiffElementsPageObject diffElements;
    private Faker faker;

    public DiffElementsStep(WebDriver _driver) {
        driver = _driver;
        diffElements = new DiffElementsPageObject(_driver);
        faker = new Faker();
    }

    public DiffElementsStep indexPage() {
        textArea();
        textBox();
        radioButton();
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

    public DiffElementsStep radioButton() {
        diffElements.radioButtonNoCheckBox().click();
        diffElements.radioButtonYesCheckBox().click();
        diffElements.radioButtonOtherCheckBox().click();
        return this;
    }
}