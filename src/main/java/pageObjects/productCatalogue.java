package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableUtility.AbstractComponent;

public class productCatalogue extends AbstractComponent {
	WebDriver driver;
	
	public productCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//PageFactory
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By find = By.cssSelector(".mb-3");
	By productNames = By.cssSelector(".card-body button:last-of-type");
	By toastClick=By.cssSelector("#toast-container");
	@FindBy(css=".ng-animating")
	WebElement element;
	
	
	
	public List<WebElement> getProductList()
	{
		waitForElementLocated(find);
		return products;
	}
	public WebElement getProductByName(String productName)
	{
		WebElement prod=getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}

	
	public void addToCart(String productName) throws InterruptedException {
		
		WebElement prod =  getProductByName(productName);
		prod.findElement(productNames).click();
		waitForElementLocated(toastClick);
		waitForInvisibilityOfElement();
		
	
	}
	
}
