package SeleniumFramework;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageObjects.CartPage;
import pageObjects.ConfirmationPage;
import pageObjects.OrdersPage;
import pageObjects.SubmitOrderPage;
import pageObjects.productCatalogue;

public class StandardTest extends BaseTest {
	String productName = "ZARA COAT 3";
	
		
		@Test(dataProvider="getData",groups= {"purchase"})
		public void submitOrder(HashMap<String,String>input) throws IOException, InterruptedException {
		  
		  productCatalogue productItems=(productCatalogue) landingPage.loginForm(input.get("email"), input.get("password"));
		  List<WebElement> products=productItems.getProductList();
		  productItems.addToCart(input.get("product"));	
		  CartPage cartPage=productItems.goToCart();
		  Boolean match=cartPage.cartList(input.get("product"));
          Assert.assertTrue(match);
          System.out.println("success");
          cartPage.scrollInToElement();
		  Thread.sleep(1000);
		  SubmitOrderPage submitOrder= cartPage.checkOutButton();
		  submitOrder.fillOrderDetails("India");
		  ConfirmationPage confirmationPage=submitOrder.submitOrder();
		  String msgText = confirmationPage.getConfirmationText();
		  Assert.assertTrue(msgText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		}
	   @Test(dependsOnMethods= {"submitOrder"})
	   public void verifyOrderPage() throws IOException, InterruptedException {
			  
		   productCatalogue productItems=(productCatalogue) landingPage.loginForm("test@practice.com", "Test1234");
			OrdersPage ordersPage =  productItems.goToOrder();
			  Assert.assertTrue(ordersPage.orderListPage(productName));
			}
//      @DataProvider
//      public Object[][] getData()
//      {
//    	  return new Object[][] {{"test@practice.com", "Test1234","ZARA COAT 3"},{"test@success.com","Test5678","ADIDAS ORIGINAL"}};
//      }
	   
	   
   @DataProvider
      public Object[][] getData() throws IOException
      {
//    	  HashMap<String,String> map = new HashMap<String,String>();
//    	  map.put("email", "test@practice.com");
//    	  map.put("password", "Test1234");
//    	  map.put("product", "ZARA COAT 3");
//    	  
//    	  HashMap<String,String> map1 = new HashMap<String,String>();
//    	  map1.put("email", "test@success.com");
//    	  map1.put("password", "Test5678");
//    	  map1.put("product", "ADIDAS ORIGINAL");
    	  List<HashMap<String,String>> data = getJsonToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\PurchaseOrder.json");
    	  
    	  return new Object[][] {{data.get(0)},{data.get(1)}};
    	  
      }
}