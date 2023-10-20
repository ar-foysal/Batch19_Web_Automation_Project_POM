package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.DriverSetup;

import java.util.List;

public class TestHomePage extends DriverSetup {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void testHomePageTitle(){
        getDriver().get(homePage.homePageUrl);
        Assert.assertEquals(getDriver().getTitle(), homePage.homePageTitle);
    }

    @Test
    public void testHomePageURL(){
        getDriver().get(homePage.homePageUrl);
        Assert.assertEquals(getDriver().getCurrentUrl(), homePage.homePageUrl);
    }

    @Test
    public void testHomePageRegistrationButton(){
        getDriver().get(homePage.homePageUrl);
        homePage.clickOnElement(homePage.registerButton);
        Assert.assertTrue(homePage.isElementVisible(homePage.registerButton));
        Assert.assertEquals(getDriver().getCurrentUrl(), registrationPage.registrationPageUrl);
    }

    @Test
    public void testHomePageLoginButton(){
        getDriver().get(homePage.homePageUrl);
        homePage.clickOnElement(homePage.loginButton);
        Assert.assertTrue(homePage.isElementVisible(homePage.loginButton));
        Assert.assertEquals(getDriver().getCurrentUrl(),loginPage.loginPageURL);
    }

    @Test
    public void getAllUrl(){
        getDriver().get(homePage.homePageUrl);
        List<WebElement> linkElements = getDriver().findElements(By.xpath("//a"));
        System.out.println("Total count: " + linkElements.size());
        for (int i =0; i<linkElements.size(); i++ ){
            System.out.println(linkElements.get(i).getText() + ": " +linkElements.get(i).getAttribute("href"));
        }
    }


}
