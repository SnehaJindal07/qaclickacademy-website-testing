package Academic.E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.Login;
import resources.base;

import java.io.IOException;

public class LoginPage extends base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(LoginPage.class);
	
	@Test(dataProvider = "getData")
	public void homePage(String username,
						 String password,
						 String text,
						 String browser) throws IOException, InterruptedException
	{
		
		driver = initializeDriver(browser);
		driver.get(prop.getProperty("url"));
		
		 LandingPage l = new LandingPage(driver);

		 Login lp = l.getLogin();
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
		Object[][] data = new Object[4][4];
		data[0][0] = "nonrestricted@abc.com";
		data[0][1] = "12345";
		data[0][2] = "Non-Restricted User";
		data[0][3] = "chrome";

		data[1][0] = "abcd@gmail.com.com";
		data[1][1] = "987654321";
		data[1][2] = "Login Successful";
		data[1][3] = "chrome";

		data[2][0] = "nonrestricted@abc.com";
		data[2][1] = "12345";
		data[2][2] = "Non-Restricted User";
		data[2][3] = "firefox";

		data[3][0] = "abcd@gmail.com.com";
		data[3][1] = "987654321";
		data[3][2] = "Login Successful";
		data[3][3] = "firefox";
		
		return data;
	}
	
}
