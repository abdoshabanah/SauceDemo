package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{


	

	public LoginPage(WebDriver driver) {
		super(DriverContext.driver);
	}

	@FindBy (id = "user-name")
	WebElement username;

	@FindBy (id = "password")
	WebElement password;

	@FindBy (id = "login-button")
	WebElement LoginBTN;
	
	@FindBy (xpath = "//div[@class='login_logo']")
	WebElement Logo;
	
	@FindBy (xpath = "//h3[@data-test='error']")
	WebElement ErrorMSG;

	public void Login(String UserName_, String Password_){

		username.sendKeys(UserName_);
		password.sendKeys(Password_);
		LoginBTN.click();

	}
	
	public void CheckLogo(String Logo_){

		Assert.assertEquals(Logo_, Logo.getText());
		System.out.println("User LoggedOut successfully");

	}
	
	
	public void CheckErrorMSG(String ErrMSG_){

		Assert.assertEquals(ErrMSG_, ErrorMSG.getText());
		System.out.println("Unsuccessful Login");

	}
	public void ReLogin(String UserName_, String Password_){

		username.clear();
		username.sendKeys(UserName_);
		
		password.clear();
		password.sendKeys(Password_);
		LoginBTN.click();

	}
}

