package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	
	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center>h2");
	By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By SignUp=By.cssSelector("a[href*='sign_up']");
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public LoginPage getLogin()
	{
		driver.findElement(signin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavBar()
	{
		return driver.findElement(NavBar);
	}
	public SignUp getSignUp()
	{
		driver.findElement(SignUp).click();
		SignUp sp = new SignUp(driver);
		return sp;
	}
}
