package Academic.E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import resources.base;

import java.io.IOException;

public class ValidateTitle extends base {
	
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(ValidateTitle.class);
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	
	
	@Test
	public void ValidateAppTitle() throws IOException
	{	 
		 LandingPage l = new LandingPage(driver);
		 Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES1");
		 
		 log.info("Successfully validated text message");
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
