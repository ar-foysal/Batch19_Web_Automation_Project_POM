package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.DriverSetup.getDriver;

public class RegistrationPage extends BasePage{
    public String registrationPageUrl = "https://demo.nopcommerce.com/register?returnUrl=%2F";
    public String registrationPageTitle = "nopCommerce demo store. Register";
    public By genderMale= By.xpath("//input[@id='gender-male']");
    public By genderFemale= By.xpath("//input[@id='gender-female']");
    public By firstName = By.id("FirstName");
    public By lastName = By.id("LastName");
    public By dayOptions = By.cssSelector("select[name='DateOfBirthDay']");

    public By dobMonth = By.xpath("//select[@name='DateOfBirthMonth']");
    public By dobYear = By.xpath("//select[@name='DateOfBirthYear']");
    public By email = By.xpath("//input[@id='Email']");
    public By companyName=By.xpath("//input[@id='Company']");
    public By password= By.xpath("//input[@id='Password']");
    public By confirmPassword=By.xpath("//input[@id='ConfirmPassword']");
    public By registerBtn= By.xpath("//button[@id='register-button']");

    public By registrationConfirmMsg = By.xpath("//div[@class='result']");

    public String registrationConfirmText = "Your registration completed";

    public void registerUser(){
        getDriver().get(registrationPageUrl);
        clickOnElement(genderMale);
        writeOnElement(firstName, "MD");
        writeOnElement(lastName, "Karim");
        selectWithVisibleText(dayOptions, "5");
        selectWithVisibleText(dobMonth, "July");
        selectWithVisibleText(dobYear, "2000");
        writeOnElement(email, "test@email.com");
        writeOnElement(companyName, "XYZ");
        writeOnElement(password, "12345A");
        writeOnElement(confirmPassword, "12345A");
        clickOnElement(registerBtn);
    }

}
