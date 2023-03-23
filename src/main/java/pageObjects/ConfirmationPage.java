package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableUtility.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
    WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[contains(@class,'hero')]")
	WebElement text;
	
	public String getConfirmationText()
	 {
		  return text.getText();
		  
	 }
	

}
