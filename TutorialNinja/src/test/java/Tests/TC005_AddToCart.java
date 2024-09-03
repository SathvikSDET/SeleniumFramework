package Tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MainPage;
import pageObjects.common.Products;
import utilites.BaseClass;

public class TC005_AddToCart extends BaseClass {
	
	private int index =0;
	private int numberOfitems =0;
	private MainPage mainPage ;
	private Products products ;

	
	@Test
	void addToCartTest() throws InterruptedException {
		mainPage =new MainPage(driver);
		products =mainPage.getProducts();
		List<String> elements  = products.getResultName();
		
		for (String element : elements) {
		    if (element.equalsIgnoreCase("iphone")) {
		        products.addToChart(index);
		        break;
		    }
		    index++;
		}
		
		Thread.sleep(5000);	
		Assert.assertTrue(mainPage.isDisplayed());
		System.out.println(mainPage.getSuccuesMessage());
	}
	
	
	@Test(dependsOnMethods = "addToCartTest")
	void addToCartTenTimesTest() throws InterruptedException { 
		mainPage =new MainPage(driver);
		products =mainPage.getProducts();
		 for (int i = 0; i <= 2; i++) {
			 products.addToChart(index);
			 Thread.sleep(5000);	
			 Assert.assertTrue(mainPage.isDisplayed());
			 numberOfitems++;
		}
		System.out.println("number of iteams"+numberOfitems);
	}
	
	
	@Test(dependsOnMethods = "addToCartTenTimesTest")
	void checkCartCount() {
		mainPage =new MainPage(driver);
		int numberOfItems = Integer.parseInt(mainPage.getCartMessage().split(" ")[0]);
		Assert.assertTrue(numberOfItems==(numberOfitems+1));
	}
	
}
