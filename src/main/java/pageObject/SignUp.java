package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUp {

    public WebDriver driver;

    By name=By.cssSelector("[id*='user_name']");
    By email=By.cssSelector("[id*='user_email']");
    By password=By.cssSelector("[id*='user_password']");
    By confirmPassword=By.cssSelector("[id*='user_password_confirmation']");
    By confirmation=By.cssSelector("[id*='user_agreed_to_terms']");
    By signUp=By.cssSelector("[value*='Sign Up']");

    public SignUp(WebDriver driver) {

        this.driver=driver;
    }

    public WebElement getNames()
    {
        return driver.findElement(name);
    }

    public WebElement getEmail()
    {
        return driver.findElement(email);
    }

    public WebElement getPassword()
    {
        return driver.findElement(password);
    }
    public WebElement getConfirmPassword()
    {
        return driver.findElement(confirmPassword);
    }

    public WebElement getConfirmation()
    {
        return driver.findElement(confirmation);
    }

    public WebElement getSignUpButton()
    {
        return driver.findElement(signUp);
    }
}
