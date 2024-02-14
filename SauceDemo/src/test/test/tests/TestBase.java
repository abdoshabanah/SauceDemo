package tests;

import java.awt.AWTException;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import pages.DriverContext;



public class TestBase {

	
	
	@BeforeTest
	public void Startdriver() throws InterruptedException, AWTException 
	{
		DriverContext.driver = new EdgeDriver();
		DriverContext.driver.manage().window().maximize();
		DriverContext.driver.get("https://www.saucedemo.com/");
		
	}
	
	
	  @AfterTest
	  public void CloseDriverContext() { 
		  
		  DriverContext.driver.quit();
	  
	  }
	 
}