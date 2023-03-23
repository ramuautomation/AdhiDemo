package ReusableUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CartPage;
import pageObjects.OrdersPage;

public class AbstractComponent {
    WebDriver driver;	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	@FindBy(css="[routerlink*='myorders']")
	WebElement orders;
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

	public void waitForElementLocated(By findBy) {
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElement(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForInvisibilityOfElement() throws InterruptedException {
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public CartPage goToCart()
	{
		cart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	public OrdersPage goToOrder()
	{
		orders.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;
	}
}
