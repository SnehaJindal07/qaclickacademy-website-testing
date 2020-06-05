package Academic.E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PracticePage extends base{

	public static Logger log = LogManager.getLogger(PracticePage.class);
	
	public WebDriver driver;

		@BeforeTest
		public void initialize() throws IOException
		{
			driver = initializeDriver();
			driver.get(prop.getProperty("table_url"));
			driver.manage().window().maximize();
			log.info(System.getProperty("os.name"));
		}
		
		@Test
		public void basePageNavigation() throws IOException, InterruptedException
		{
		
			
		//	Radio button example
			driver.findElement(By.xpath(".//*[@value='radio2']")).click();
			
		//	Suggestion Class example
			driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("UNITED");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
			log.info(driver.findElement(By.xpath("//input[@id='autocomplete']")).getText());
			JavascriptExecutor js= (JavascriptExecutor)driver;

			String script = "return document.getElementById(\"autocomplete\").value;";
			String text=(String) js.executeScript(script);
			log.info(text);
			int i =0;
			while(!text.equalsIgnoreCase("United States (USA)"))
			{
				i++;
				driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
				text=(String) js.executeScript(script);
				log.info(text);
				if(i>5)
					break;
			}

			if(i>5)
				log.info("Country not found");
			else
				log.info("Country  found");
			
			
		//	Drop down Example
			driver.findElement(By.id("dropdown-class-example")).click();
			driver.findElement(By.xpath(".//*[@value='option1']")).click();
			
		//	Check-box Example	
			driver.findElement(By.id("checkBoxOption1")).click();
		
		//	Web Table Example	
			WebElement table = driver.findElement(By.className("table-display"));
			log.info(table.findElements(By.tagName("tr")).size());
			log.info(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
			List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(4).findElements(By.tagName("td"));
		
			log.info(secondrow.get(0).getText());
			log.info(secondrow.get(1).getText());
			log.info(secondrow.get(2).getText());
			
			
		//	Switch  to alert example
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.name("enter-name")).sendKeys("SNEHA");
			driver.findElement(By.xpath(".//*[@id='alertbtn']")).click();
			
			driver.switchTo().alert().accept();
			
			driver.findElement(By.xpath(".//*[@id='confirmbtn']")).click();
			driver.switchTo().alert().dismiss();
			
			driver.findElement(By.xpath(".//*[@id='confirmbtn']")).click();
			driver.switchTo().alert().accept();
		
		//	switch tab example	
		    driver.findElement(By.id("opentab")).sendKeys(System.getProperty("os.name").contains("Mac") ? Keys.COMMAND : Keys.CONTROL,Keys.ENTER);	
		
		//	Get title of the window
		    Thread.sleep(5000L);
		    Set<String> abc=driver.getWindowHandles();
		    Iterator<String> it=abc.iterator();
		    
		    while(it.hasNext())
		    {
		    	driver.switchTo().window(it.next());
		    	log.info("Window Title is " +driver.getTitle());
		    }
		
		
		}
		
		@AfterTest
		public void teardown()
		{
			driver.quit();
		}
	}
