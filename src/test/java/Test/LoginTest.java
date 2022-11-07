package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	Logger log;
	public WebDriver driver;
	@Test(dataProvider="getLoginData")
	public void Login(String email,String password,String expectedresult) throws IOException
		{
		
		LandingPage landingpage=new LandingPage(driver);
		landingpage.myAccountDropDown().click();
		log.debug("Clicked on My Account dropdown");
		landingpage.loginOption().click();
		log.debug("Clicked on login option");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.emailAddressField().sendKeys(email);
		log.debug("Email addressed got entered");
		loginpage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginpage.loginButton().click();
		log.debug("Clicked on Login Button");
		AccountPage accountpage=new AccountPage(driver);
		String acutualresult=null;
		try {
			if(accountpage.editAccountInformationOption().isDisplayed())
			{
				 log.debug("User got logged in");
				acutualresult="Successfull";
			}
		}
			catch(Exception e)
			{
				log.debug("User didn't log in");
				acutualresult="Failure";
			}
		
		Assert.assertEquals(acutualresult,expectedresult);
		log.info("Login Test got passed");
		}
	
@BeforeMethod		
public void openApplication() throws IOException
{
	log = LogManager.getLogger(LoginTest.class.getName());
	driver = initializeBrowser();
	log.debug("Browser got launched");
	driver.get(prop.getProperty("url"));
	log.debug("Navigated to application URL");
}
		
	
@AfterMethod
public void close()
{
	driver.close();
	log.debug("Browser got closed");
}

@DataProvider
public Object[][] getLoginData()
{
 Object[][] data= {{"tina88@gmail.com","123456789","Successfull"},{"dummy@gmail.con","dummy","Failure"}};	
 return data;
}
}
