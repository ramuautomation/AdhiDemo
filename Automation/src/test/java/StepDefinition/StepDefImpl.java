package StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.SubmitOrderPage;
import pageObjects.productCatalogue;

public class StepDefImpl extends BaseTest {
	
	public LandingPage landingPage;
	public productCatalogue productItems;
	public CartPage cartPage;
	public SubmitOrderPage submitOrder;
	public ConfirmationPage confirmationPage;
	@Given("I launch Ecommerce application")
	public void I_launch_Ecommerce_application() throws IOException
	{
		landingPage= launchApplication();
	}

	@Given("^Logged in with user (.+) and password (.+)$")
	public void Logged_in_with_user_and_password(String name,String password)
	{
		productItems=(productCatalogue) landingPage.loginForm(name, password);
	}
	
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products=productItems.getProductList();
		  //productItems.addToCart(productName);
		  productItems.addToCart(productName);
	}
	@And("^Checkout (.+) and Submit the Order$")
	public void Checkout_product_and_Submit_Orders(String productName) throws InterruptedException
	{
		  cartPage=productItems.goToCart();
		  Boolean match=cartPage.cartList(productName);
          Assert.assertTrue(match);
          cartPage.scrollInToElement();
		  Thread.sleep(1000);
		  submitOrder= cartPage.checkOutButton();
		  submitOrder.fillOrderDetails("India");
		  confirmationPage=submitOrder.submitOrder();
	}
	@Then("{string} message is displayed on the confirmation page")
	public void message_is_displayed_on_the_confirmation_page(String string)
	{
		String msgText = confirmationPage.getConfirmationText();
		  Assert.assertTrue(msgText.equalsIgnoreCase(string));
		  driver.close();
	}
	@Then("{string} error message is displayed")
	public void error_msg_displayed_at_loginpage(String string)
	{
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.close();
	}
	
}
