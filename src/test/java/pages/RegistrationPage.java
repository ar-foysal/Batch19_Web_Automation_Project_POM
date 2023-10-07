package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage{
    public String registrationPageUrl = "https://demo.nopcommerce.com/register?returnUrl=%2F";
    public String registrationPageTitle = "nopCommerce demo store. Register";
    public By genderCheckbox = By.xpath("//input[@id='gender-male']");
    public By firstName = By.id("FirstName");
    public By lastName = By.id("LastName");
    public WebElement dayDropdown = getElement(By.cssSelector("select[name='DateOfBirthDay']"));
}
