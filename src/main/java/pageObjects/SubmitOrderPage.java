package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ReusableUtility.AbstractComponent;

public class SubmitOrderPage extends AbstractComponent {
	WebDriver driver;
	
	public SubmitOrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//PageFactory
	@FindBy(css="[placeholder*='Select']")
	WebElement select;
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selection;
	@FindBy(xpath="//*[contains(@class,'submit')]")
	WebElement submit;
	
	By find = By.cssSelector("[placeholder*='Select']");
	
	 public void fillOrderDetails(String country)
	 {
		 waitForElementLocated(find);
		 Actions a = new Actions(driver);
		  a.sendKeys(select,country).build().perform();
		  selection.click();
		  
	 }
	 public ConfirmationPage submitOrder()
	 {
		 submit.click();
		 ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		 return confirmationPage;
	 }
	 
	 
	}
	

