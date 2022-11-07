package Test;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {
	public WebDriver driver;
	@Test
public void fourtest () throws IOException, InterruptedException
{
	System.out.println("FourTest");
	driver = initializeBrowser();
	driver.get("http://tutorialsninja.com/demo/");
	Thread.sleep(2000);
	Assert.assertTrue(false);
	
}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
