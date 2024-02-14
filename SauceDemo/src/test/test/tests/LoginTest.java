package tests;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.*;

public class LoginTest extends TestBase{


	LoginPage 			LoginObject;
	HomePage 			HomeObject;


	public void ImplicitlyWaitfor(int wait) throws InterruptedException
	{
		DriverContext.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
	}


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
	
	@DataProvider(name="LogoData")
	public Object[][] LogoData() throws IOException
	{ 
		ExcelReader ER = new ExcelReader();
		return ER.LogoData();
	}


	@Test(priority=2,alwaysRun=true,dataProvider="LogoData")

	public void Logout(String Logo_) throws InterruptedException {

		HomeObject.Logout();
		LoginObject.CheckLogo(Logo_);
	}
	
	@DataProvider(name="UnSuccessfulLoginData")
	public Object[][] UnSuccessfulLoginData() throws IOException
	{ 
		ExcelReader ER = new ExcelReader();
		return ER.GetUnSuccessfulLoginData();
	}
	
	
	@Test(priority=3,alwaysRun=true,dataProvider="UnSuccessfulLoginData")
	public void FailedLogin(String UN_, String PW_,String ERRMSG_) throws InterruptedException {

		LoginObject.Login( UN_, PW_);
		LoginObject.CheckErrorMSG(ERRMSG_);
		
	}
	
	@Test(priority=4,alwaysRun=true,dataProvider="LoginData")
	public void ReLogin(String UN, String PW,String Label) throws InterruptedException {

		LoginObject.ReLogin( UN, PW);
		HomeObject.CheckLabel(Label);
	}
}
