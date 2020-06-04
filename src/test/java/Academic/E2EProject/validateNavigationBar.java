package Academic.E2EProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import pageObject.LandingPage;
import resources.base;

public class validateNavigationBar extends base {

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void basePageNavigation() throws IOException
	{
		 LandingPage l = new LandingPage(driver);
		 Assert.assertTrue(l.getNavBar().isDisplayed());
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
