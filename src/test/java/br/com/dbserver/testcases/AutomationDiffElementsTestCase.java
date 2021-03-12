package br.com.dbserver.testcases;

import br.com.dbserver.utils.BaseTest;
import br.com.dbserver.utils.Property;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static br.com.dbserver.webdrivers.DriverManager.*;

public class AutomationDiffElementsTestCase extends BaseTest {

    @Test
    public void diffElementsTest() {
        WebDriver driver = getDriver();
        driver.get(Property.get("url"));
    }
}