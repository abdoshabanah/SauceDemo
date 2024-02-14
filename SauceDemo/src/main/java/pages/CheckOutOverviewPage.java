package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;


@SuppressWarnings("deprecation")
public class CheckOutOverviewPage extends PageBase{


	

	public CheckOutOverviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//*[@id=\"item_4_title_link\"]/div")
	WebElement Product;
	@FindBy (id = "finish")
	WebElement FinishBTN;

	

	public void FinishCheckOut(String ProductName){

		System.out.println(Product.getText());
		Assert.assertEquals(Product.getText(), ProductName);
		FinishBTN.click();
		
	}
	
	
	}

