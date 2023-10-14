package testcases;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DemoLoginPage;
import utilities.DataSet;
import utilities.DriverSetup;

public class DemoLoginTest extends DriverSetup {
    DemoLoginPage demoLoginPage = new DemoLoginPage();

    @BeforeMethod
    public void navigateToLoginPage(){
        getDriver().get(demoLoginPage.loginPageURL);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void testLoginWithValidCredentials(){
        demoLoginPage.writeOnElement(demoLoginPage.username, "standard_user");
        demoLoginPage.writeOnElement(demoLoginPage.password, "secret_sauce");
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        demoLoginPage.addScreenShot("After clicking on login button");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void testLoginWithoutPassword(){
        demoLoginPage.writeOnElement(demoLoginPage.username, "standard_user");
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        demoLoginPage.addScreenShot("After clicking on login button");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error), "Epic sadface: Password is required");
    }

    @Test
    public void testLoginWithoutUsername(){
        demoLoginPage.writeOnElement(demoLoginPage.username, "");
        demoLoginPage.writeOnElement(demoLoginPage.password, "secret_sauce");
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        demoLoginPage.addScreenShot("After clicking on login button");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error), "Epic sadface: Username is required");
    }

    @Test
    public void testLoginWithoutCredentials(){
        demoLoginPage.writeOnElement(demoLoginPage.username, "");
        demoLoginPage.writeOnElement(demoLoginPage.password, "");
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        demoLoginPage.addScreenShot("After clicking on login button");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error), "Epic sadface: Username is required");
    }

    @Test(dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
    public void testLoginWithInvalidCredentials(String username, String password, String error_msg){
        demoLoginPage.writeOnElement(demoLoginPage.username, username);
        demoLoginPage.writeOnElement(demoLoginPage.password, password);
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        demoLoginPage.addScreenShot("After clicking on login button");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error), error_msg);
    }


}
