package Tests;

import java.util.List;

import javax.naming.directory.SearchResult;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MainPage;
import pageObjects.SearchResultPage;
import pageObjects.common.Products;
import pageObjects.common.Search;
import utilites.BaseClass;

public class TC006_CheckSearchResult  extends BaseClass{
	

	
	@Test
	void verifySearchResult() {
		Search search = new MainPage(driver).getSearch();
		search.setSearch("iphone");
		search.clickSearch();

		SearchResultPage resultPage = new SearchResultPage(driver);

		Assert.assertTrue(resultPage.isDisplayed());

		Products products = resultPage.getProduct();
		
		Assert.assertTrue(products.seachResultcount() > 0);

		products.getResultName().stream().forEach(System.out::println);

	}
}
