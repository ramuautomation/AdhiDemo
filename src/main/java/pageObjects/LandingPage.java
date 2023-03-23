package pageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableUtility.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public productCatalogue  loginForm(String name,String password)
	{
		userName.sendKeys(name);
		userPassword.sendKeys(password);
		login.click();
		productCatalogue productItems = new productCatalogue(driver);
		return productItems;
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	public String getErrorMessage()
	{
		waitForElement(errorMessage);
		return errorMessage.getText();
	}

}
