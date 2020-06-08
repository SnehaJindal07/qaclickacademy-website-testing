package Academic.E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.SignUp;
import resources.base;

import java.io.IOException;
import java.util.Random;

public class SignUpPage extends base {

    public WebDriver driver;
    public static Logger log = LogManager.getLogger(Academic.E2EProject.SignUpPage.class);

    @Test(dataProvider = "getData")
    public void homePage(String name, String emails, String password,
                         String confirmPasswords) throws IOException, InterruptedException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));

        LandingPage l = new LandingPage(driver);

        SignUp sp = l.getSignUp();
        sp.getNames().sendKeys(name);
        sp.getEmail().sendKeys(emails);
        sp.getPassword().sendKeys(password);
        sp.getConfirmPassword().sendKeys(confirmPasswords);
        sp.getConfirmation().click();
        sp.getSignUpButton().click();

        log.info("SignUp done successfully");

        driver.close();
    }

    @DataProvider
    public Object[][] getData()
    {
        Random random = new Random();
        Object[][] data = new Object[1][4];
        data[0][0] = "apple";
        data[0][1] = "test" + System.currentTimeMillis() + "@gmail.com";
        data[0][2] = "1234567";
        data[0][3] = "1234567";

        return data;
    }
}


