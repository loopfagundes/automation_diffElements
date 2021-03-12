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
        return this;
    }
}