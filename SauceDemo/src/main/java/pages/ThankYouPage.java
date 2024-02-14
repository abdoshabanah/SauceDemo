package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;


@SuppressWarnings("deprecation")
public class ThankYouPage extends PageBase{


	

	public ThankYouPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//h2[contains(.,'Thank you for your order!')]")
	WebElement ThanksLabel;
	
	@FindBy (id = "back-to-products")
	WebElement BackHomeBTN;
	
	@FindBy (xpath = "//*[@id=\"header_container\"]/div[2]/span")
	WebElement ProductLabel;
	public void CheckThanksLabel(){

		System.out.println(ThanksLabel.getText());
		Assert.assertEquals(ThanksLabel.getText(), "Thank you for your order!");
		
	}
	public void CheckBackHome(){

		BackHomeBTN.click();
		Assert.assertEquals(ProductLabel.getText(), "Products");
	}
	
	}

