package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShoppingCardPage extends PageBase{


	

	public ShoppingCardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//span[contains(.,'Your Cart')]")
	WebElement PageLabel;
	@FindBy (id = "checkout")
	WebElement checkoutBTN;
	

	public void CheckLabel(String Label){

		Assert.assertEquals(Label, PageLabel.getText());

	}
	public void ProceedCheckout(){

		checkoutBTN.click();

	}
	
	
	}

