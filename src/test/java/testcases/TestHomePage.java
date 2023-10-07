package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.DriverSetup;

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



}
