package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.common.Products;

public class SearchResultPage extends BasePomClass {
	
	
	Products products;
	
	@FindBy(xpath = "//h1[starts-with(text(), 'Search')]")
	public WebElement searchText;
	
	@FindBy(xpath = "//i[@class='fa fa-th']")
	WebElement gridView;
	

	public SearchResultPage(WebDriver driver) {
		super(driver);
		this.products =new Products(driver);
	}
	
	public Products getProduct() {
		return products;
	}
	

	@Override
	public boolean isDisplayed() {
		return searchText.isDisplayed();
	}

}
