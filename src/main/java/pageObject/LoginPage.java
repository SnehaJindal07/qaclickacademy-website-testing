package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	
	public WebDriver driver;
	
	By email=By.cssSelector("[id*='user_email']");
	By password=By.cssSelector("[id*='user_password']");
	By Login=By.cssSelector("[value*='Log In']");

	
	public LoginPage(WebDriver driver) {
	
		this.driver=driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPass()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(Login);
	}
}
