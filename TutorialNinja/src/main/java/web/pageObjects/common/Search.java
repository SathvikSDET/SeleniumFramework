package pageObjects.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePomClass;

public class Search extends BasePomClass{

	public Search(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement searchButton;
	
	public void setSearch(String search){
		searchBox.sendKeys(search);
	}
	public void clickSearch(){
		searchButton.click();
	}
	
	@Override
	public boolean isDisplayed() {
		return searchBox.isDisplayed();
	}
	
	
}
