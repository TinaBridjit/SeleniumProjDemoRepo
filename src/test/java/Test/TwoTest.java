package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	public WebDriver driver;
@Test	
public void twotest() throws IOException, InterruptedException
{
	System.out.println("TwoTest");
	 driver = initializeBrowser();
	driver.get("http://tutorialsninja.com/demo/");
	Thread.sleep(2000);
	driver.close();
}
}
