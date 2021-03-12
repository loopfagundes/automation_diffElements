package br.com.dbserver.steps;

import br.com.dbserver.pageobjects.DiffElementsPageObject;
import org.openqa.selenium.WebDriver;

public class DiffElementsStep {
    private final WebDriver driver;
    private final DiffElementsPageObject diffElements;

    public DiffElementsStep(WebDriver _driver) {
        driver = _driver;
        diffElements = new DiffElementsPageObject(_driver);
    }

    public DiffElementsStep indexPage() {
        return this;
    }
}