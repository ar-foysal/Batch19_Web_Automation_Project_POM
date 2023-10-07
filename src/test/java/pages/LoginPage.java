package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public String loginPageTitle = "nopCommerce demo store. Login";
    public String loginPageURL = "https://demo.nopcommerce.com/login";
    public By inputEmail = By.xpath("//input[@id='Email']");
    public By inputPassword = By.xpath("//input[@id='Password']");
    public By rememberMeCheckBox = By.xpath("//input[@id='RememberMe']");
    public By forgotPasswordButton = By.xpath("//a[normalize-space()='Forgot password?']");
    public By loginButton = By.xpath("//button[normalize-space()='Log in']");
}
