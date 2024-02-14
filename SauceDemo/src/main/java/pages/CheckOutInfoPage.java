package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckOutInfoPage extends PageBase{


	

	public CheckOutInfoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (id = "first-name")
	WebElement FirstName;
	@FindBy (id = "last-name")
	WebElement LastName;
	@FindBy (id = "postal-code")
	WebElement PostalCode;
	@FindBy (id = "continue")
	WebElement ContinueBTn;

	
	public void AddCheckOutInfo(String FName, String LName, String PostalC){

		FirstName.sendKeys(FName);
		LastName.sendKeys(LName);
		PostalCode.sendKeys(PostalC);
		ContinueBTn.click();
	}
	
	
	}

