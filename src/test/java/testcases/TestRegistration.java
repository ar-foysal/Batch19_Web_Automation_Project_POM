package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utilities.DriverSetup;

public class TestRegistration extends DriverSetup {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    public void testUserRegistrationProcess(){
//        getDriver().get(registrationPage.registrationPageUrl);
//        registrationPage.clickOnElement(registrationPage.genderMale);
//        registrationPage.writeOnElement(registrationPage.firstName, "MD");
//        registrationPage.writeOnElement(registrationPage.lastName, "Karim");
//        registrationPage.selectWithVisibleText(registrationPage.dayOptions, "5");
//        registrationPage.selectWithVisibleText(registrationPage.dobMonth, "July");
//        registrationPage.selectWithVisibleText(registrationPage.dobYear, "2000");
//        registrationPage.writeOnElement(registrationPage.email, "test@email.com");
//        registrationPage.writeOnElement(registrationPage.companyName, "XYZ");
//        registrationPage.writeOnElement(registrationPage.password, "12345A");
//        registrationPage.writeOnElement(registrationPage.confirmPassword, "12345A");
//        registrationPage.clickOnElement(registrationPage.registerBtn);
        registrationPage.registerUser();
        Assert.assertTrue(registrationPage.isElementVisible(registrationPage.registrationConfirmMsg));
        Assert.assertEquals(registrationPage.getElementText(registrationPage.registrationConfirmMsg), registrationPage.registrationConfirmText);
    }
}
