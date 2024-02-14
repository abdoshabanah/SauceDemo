package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageBase{


	

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//span[@class='title']")
	WebElement ProductsLabel;

	@FindBy (id = "react-burger-menu-btn")
	WebElement MenuBTN;
	
	@FindBy (id = "logout_sidebar_link")
	WebElement LogoutBTN;
	
	@FindBy (xpath = "//*[@id=\"item_4_title_link\"]/div")
	WebElement ProductName;
	
	@FindBy (id = "add-to-cart-sauce-labs-backpack")
	WebElement AddProductBTN;

	@FindBy (id = "remove-sauce-labs-backpack")
	WebElement RemoveProductBTN;
	
	@FindBy (xpath = "//span[@class='shopping_cart_badge']")
	WebElement ShoppingCardBadge;
	
	@FindBy (id = "shopping_cart_container")
	WebElement ShoppingCard;
	
	String ProductN;

	public void CheckLabel(String Label){

		Assert.assertEquals(Label, ProductsLabel.getText());
		System.out.println("User LoggedIn successfully");

	}
	
	public void Logout() throws InterruptedException{

		MenuBTN.click();
		Thread.sleep(300);
		LogoutBTN.click();

	}
	
	
	public void AddToCard() throws InterruptedException{
		Thread.sleep(300);
		AddProductBTN.click();
		Thread.sleep(300);
		Assert.assertEquals("Remove", RemoveProductBTN.getText());
		Assert.assertEquals("1", ShoppingCardBadge.getText());
		ProductN = ProductName.getText();
		System.out.println(ProductN+" Added Successfully");
		

	}
	public void RemoveFromCard() throws InterruptedException{
		Thread.sleep(300);
		RemoveProductBTN.click();
		Assert.assertEquals("Add to cart", AddProductBTN.getText());
		System.out.println("Product Removed Successfully");
	}
	public void ReAddToCard() throws InterruptedException{

		AddProductBTN.click();
		Assert.assertEquals("Remove", RemoveProductBTN.getText());
		Assert.assertEquals("1", ShoppingCardBadge.getText());
		System.out.println("Product ReAdded Successfully");

	}
	public void OpenCard() throws InterruptedException{

		ShoppingCard.click();

	}
}

