package web.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import web.pageObjects.common.currency.CurrencyConfig;
import web.pageObjects.common.currency.CurrencyFactory;
import web.utilites.BaseClass;
import web.utilites.Dataprovider;

public class TC003_CurrencyCheck extends BaseClass {
	public CurrencyConfig currency;
	
	@Test(dataProvider = "CurrecyData", dataProviderClass = Dataprovider.class)
	void currencyCheckTest(String currency) {
		this.currency = CurrencyFactory.get(currency, driver);
		this.currency.setCurrency();
		System.out.println("Currency type : "+currency);
		AssertJUnit.assertTrue(this.currency.checkPriceChange());
		

	}

}
