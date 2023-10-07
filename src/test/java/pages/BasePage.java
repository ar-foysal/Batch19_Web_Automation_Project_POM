package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.DriverSetup.getDriver;


public class BasePage {

    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }
}
