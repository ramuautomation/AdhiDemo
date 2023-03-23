package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import ReusableUtility.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//PageFactory
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProduct;
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement checkOut;
	public Boolean cartList(String productName)
	{
		Boolean match=cartProduct.stream().anyMatch(ordered->ordered.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	public void scrollInToElement() {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		  js.executeScript("arguments[0].scrollIntoView(true);",checkOut );	
	}
	 public SubmitOrderPage checkOutButton()
	 {
		 checkOut.click();
		 SubmitOrderPage submitOrder = new SubmitOrderPage(driver);
		 return submitOrder;
	 }
	}
	

