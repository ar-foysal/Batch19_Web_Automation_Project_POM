package testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoLoginPage;
import pages.DemoProductPage;
import utilities.DriverSetup;

public class TestProductPage extends DriverSetup {
    DemoLoginPage demoLoginPage = new DemoLoginPage();
    DemoProductPage demoProductPage = new DemoProductPage();
    @BeforeMethod
    public void navigateToProductPage(){
        getDriver().get(demoLoginPage.loginPageURL);
        demoLoginPage.doLogin("standard_user", "secret_sauce");
    }
    @Test(description = "Test product page Add to cart button")
    @Description("Allure Description Test product page Add to cart button")
    public void testAddTCartButton(){
        demoProductPage.clickOnElement(demoProductPage.addToCartButton);
        demoProductPage.addScreenShot("Add product to cart");
        Assert.assertEquals(demoProductPage.getCurrentCartItemCount(), "1");
    }

    @Test
    public void testRemoveCartItemButton(){
//        demoProductPage.clickOnElement(demoProductPage.addToCartButton);
        demoProductPage.clickOnElement(demoProductPage.removeCartItemButton);
        demoProductPage.addScreenShot("Remove product from cart");
        Assert.assertTrue(demoProductPage.isElementVisible(demoProductPage.addToCartButton));
        Assert.assertFalse(demoProductPage.isElementVisible(demoProductPage.removeCartItemButton));
    }
}
