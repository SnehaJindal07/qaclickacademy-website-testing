package Academic.E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

import java.io.IOException;

public class HomePage extends base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class);
	
	@Test(dataProvider = "getData")
	public void homePage(String username, String password, String text) throws IOException, InterruptedException
	{
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		 LandingPage l = new LandingPage(driver);

		 LoginPage lp = l.getLogin();
		 lp.getEmail().sendKeys(username);
		 lp.getPass().sendKeys(password);
		 log.info(text);
		 lp.getLogin().click();
		 ForgotPassword fp = lp.forgotPassword();
		 fp.getEmail().sendKeys("xxx");
		 fp.sendInstructions().click();
		 
		 driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricted@abc.com";
		data[0][1] = "12345";
		data[0][2] = "Non-Restricted User";
		
		
		data[1][0] = "abcd@gmail.com.com";
		data[1][1] = "987654321";
		data[1][2] = "Login Successful";
		
		return data;
	}
	
}
