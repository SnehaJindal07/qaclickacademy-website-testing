package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

	public WebDriver driver;
	public Properties prop;

	public static Logger log = LogManager.getLogger(base.class);

	public WebDriver initializeDriver(String browser) throws IOException
	{
		prop = new Properties();

		String projectFolder = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(projectFolder + "//src//main//java//resources//data.properties");
		prop.load(fis);

		String browserName=prop.getProperty("browser");
		log.info("Running test in " + browserName);

		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver", projectFolder + "//src//main//java//resources//chromedriver");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.gecko.driver", projectFolder + "//src//main//java//resources//geckodriver");
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports//images//"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return "images//"+ testCaseName + ".png";
	}
}
