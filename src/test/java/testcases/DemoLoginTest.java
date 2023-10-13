package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoLoginPage;
import utilities.DataSet;
import utilities.DriverSetup;

public class DemoLoginTest extends DriverSetup {
    DemoLoginPage demoLoginPage = new DemoLoginPage();
    @Test
    public void testLoginWithValidCredentials(){
        getDriver().get(demoLoginPage.loginPageURL);
        demoLoginPage.writeOnElement(demoLoginPage.username, "standard_user");
        demoLoginPage.writeOnElement(demoLoginPage.password, "secret_sauce");
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void testLoginWithoutPassword(){
        getDriver().get(demoLoginPage.loginPageURL);
        demoLoginPage.writeOnElement(demoLoginPage.username, "standard_user");
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error), "Epic sadface: Password is required");
    }

    @Test
    public void testLoginWithoutUsername(){
        getDriver().get(demoLoginPage.loginPageURL);
        demoLoginPage.writeOnElement(demoLoginPage.username, "");
        demoLoginPage.writeOnElement(demoLoginPage.password, "secret_sauce");
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error), "Epic sadface: Username is required");
    }

    @Test
    public void testLoginWithoutCredentials(){
        getDriver().get(demoLoginPage.loginPageURL);
        demoLoginPage.writeOnElement(demoLoginPage.username, "");
        demoLoginPage.writeOnElement(demoLoginPage.password, "");
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error), "Epic sadface: Username is required");
    }

    @Test(dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
    public void testLoginWithInvalidCredentials(String username, String password, String error_msg){
        getDriver().get(demoLoginPage.loginPageURL);
        demoLoginPage.writeOnElement(demoLoginPage.username, username);
        demoLoginPage.writeOnElement(demoLoginPage.password, password);
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error), error_msg);
    }

}
