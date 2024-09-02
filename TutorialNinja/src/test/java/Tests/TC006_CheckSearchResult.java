package Tests;

import org.testng.annotations.Test;

import pageObjects.MainPage;
import pageObjects.common.Search;

public class TC006_CheckSearchResult  extends BaseClass{
	
	public MainPage main;
	
	@Test
	void verifySearchResult() {
	   Search search=main.getSearch();
	   search.setSearch("iphone");
	   search.clickSearch();
		
	}

}
