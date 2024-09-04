package web.pageObjects.common;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.pageObjects.BasePomClass;

public class Products extends BasePomClass {
	
	
	public Products(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[starts-with(@class,\"product-layout\")]//h4")
	List<WebElement> searchResultName;
	
	
	
	
	 public int seachResultcount(){
		return searchResultName.size();
	}
	 
	public List<String> getResultName(){
		return searchResultName.stream()
								.map(WebElement::getText)
								.collect(Collectors.toList());
	}
	
	public WebElement getAddToCartElement(int index) {
	    String dynamicXPath = "(//div[@class='button-group'])[" + index + "]//*[@class='fa fa-shopping-cart']";
	    return driver.findElement(By.xpath(dynamicXPath));
	}

	public void addToChart(int index) {
		WebElement addToCart = getAddToCartElement(index);
		addToCart.click();
		
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return searchResultName.get(0).isDisplayed();
	}


}
