package SeleniumFramework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.Retry;
import pageObjects.CartPage;
import pageObjects.ConfirmationPage;
import pageObjects.SubmitOrderPage;
import pageObjects.productCatalogue;

public class ErrorValidationTest extends BaseTest {

	
		
		@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
		public void VerifyLoginError(){
		  landingPage.loginForm("test123@practice.com", "Test");
		  Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		  
		}
		@Test
		public void ProductError() throws IOException, InterruptedException {
			  String productName = "ZARA COAT 3";
			  productCatalogue productItems=(productCatalogue) landingPage.loginForm("test@practice.com", "Test1234");
			  List<WebElement> products=productItems.getProductList();
			  productItems.addToCart(productName);	
			  CartPage cartPage=productItems.goToCart();
			  Boolean match=cartPage.cartList("ZARA COAT 45");
	          Assert.assertFalse(match);
			}
	

}