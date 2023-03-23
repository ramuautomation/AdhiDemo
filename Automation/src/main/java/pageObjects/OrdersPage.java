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

public class OrdersPage extends AbstractComponent {
	WebDriver driver;
	
	public OrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//PageFactory
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ordersList;
	
	public Boolean orderListPage(String productName)
	{
		Boolean match=ordersList.stream().anyMatch(ordered->ordered.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	}
	

