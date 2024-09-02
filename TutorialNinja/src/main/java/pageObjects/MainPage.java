package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.common.MyAccount;
import pageObjects.common.Products;
import pageObjects.common.Search;

public class MainPage extends BasePomClass {
	
	private MyAccount myAccount;
	private Search search;
	private Products products;
	
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessage;

	public MainPage(WebDriver driver) {
		super(driver);
		this.myAccount = PageFactory.initElements(driver, MyAccount.class);	
		this.search= PageFactory.initElements(driver, Search.class);	
		this.products =new Products(driver);
	}

	public MyAccount getMyAccount() {
	        return myAccount;
	}
	
	public Search getSearch() {
		return search;
	}
	
	public Products getProducts() {
		return products;
	}

	public String getSuccuesMessage() {
		return successMessage.getText();
	}

	
	@Override
	public boolean isDisplayed() {
		return successMessage.isDisplayed();
	}
}
