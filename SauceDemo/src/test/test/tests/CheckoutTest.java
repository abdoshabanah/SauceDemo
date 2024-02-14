package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.*;

public class CheckoutTest extends TestBase{


	HomePage 				HomeObject;
	LoginPage 				LoginObject;
	ShoppingCardPage		ShoppingCardObject;
	CheckOutInfoPage		CheckOutObject;
	CheckOutOverviewPage 	CheckOutOverviewObject;
	ThankYouPage			ThankYouObject;
	
	
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
		HomeObject.OpenCard();
	}
	
	
	@DataProvider(name="CheckOutData")
	public Object[][] ShoppingCardData() throws IOException
	{ 
		ExcelReader ER = new ExcelReader();
		return ER.GetShoppingCardData();
	}

	@Test(priority=3,alwaysRun=true,dataProvider="CheckOutData")
	public void Checkout(String Label_) throws InterruptedException {

		ShoppingCardObject = new ShoppingCardPage(DriverContext.driver);
		ShoppingCardObject.CheckLabel(Label_);
		ShoppingCardObject.ProceedCheckout();
	}
	
	@DataProvider(name="CheckOutinfo")
	public Object[][] CheckOutInfoData() throws IOException
	{ 
		ExcelReader ER = new ExcelReader();
		return ER.CheckoutData();
	}

	@Test(priority=4,alwaysRun=true,dataProvider="CheckOutinfo")
	public void Checkoutinfo(String FirstN,String LastN, String Postal) throws InterruptedException {
		CheckOutObject = new CheckOutInfoPage(DriverContext.driver);
		CheckOutObject.AddCheckOutInfo(FirstN, LastN, Postal);
		
	}
	
	@DataProvider(name="ProductName")
	public Object[][] ProductNameData() throws IOException
	{ 
		ExcelReader ER = new ExcelReader();
		return ER.ProductName();
	}

	@Test(priority=5,alwaysRun=true,dataProvider="ProductName")
	public void CompleteCheckout(String ProductN_) throws InterruptedException {
		CheckOutOverviewObject =new CheckOutOverviewPage(DriverContext.driver);
		CheckOutOverviewObject.FinishCheckOut(ProductN_);
		
		ThankYouObject = new ThankYouPage(DriverContext.driver);
		ThankYouObject.CheckThanksLabel();
		
	}
	
	@Test(priority=6)
	public void BackHome() throws InterruptedException {
		ThankYouObject.CheckBackHome();
		
	}
	
	
}
