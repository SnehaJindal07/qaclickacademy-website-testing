package Academic.E2EProject;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base{

//	@BeforeTest
//	public void initialize() throws IOException
//	{
//		driver = initializeDriver();
//	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException, InterruptedException 
	{
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		

		 System.out.println(username + " "+ password + " " + text);
		 LandingPage l = new LandingPage(driver);
		 l.getLogin().click();
		 
		 LoginPage lp = new LoginPage(driver);
		 lp.getEmail().sendKeys(username);
		 lp.getPass().sendKeys(password);
		 System.out.println(text);
		 lp.getLogin().click();	 
	}
	
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricted@abc.com";
		data[0][1] = "12345";
		data[0][2] = "Non-Restricted User";
		
		
		data[1][0] = "restricted@abc.com";
		data[1][1] = "98765";
		data[1][2] = "Restricted User";
		
		return data;
	}
}
