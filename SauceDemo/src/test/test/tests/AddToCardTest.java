package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.*;

public class AddToCardTest extends TestBase{


	HomePage 		HomeObject;
	LoginPage 			LoginObject;
	
	

	@DataProvider(name="LoginData")
	public Object[][] userRegisterData() throws IOException
	{ 
		ExcelReader ER = new ExcelReader();
		return ER.GetLoginData();
	}

	@Test(priority=1,alwaysRun=true,dataProvider="LoginData")
	public void SuccessLogin(String UN, String PW,String Label) throws InterruptedException {


		LoginObject = new LoginPage(DriverContext.driver);
		LoginObject.Login( UN, PW);

		HomeObject= new HomePage(DriverContext.driver);
		HomeObject.CheckLabel(Label);
	}
	
	@Test(priority=2)
	public void AddToCard() throws InterruptedException {
		HomeObject.AddToCard();
	}
	
	@Test(priority=3)
	public void RemoveFromCard() throws InterruptedException {

		HomeObject.RemoveFromCard();
		
	}
	
	
}
