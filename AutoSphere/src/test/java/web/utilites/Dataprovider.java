package web.utilites;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.collections.Maps;

import web.Utilities.ExcelUtils;

public class Dataprovider {
	
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
	String path=System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Opencart_LoginData.xlsx";
	ExcelUtils xlutil=new ExcelUtils(path);//creating an object for XLUtility
	
	int totalrows=xlutil.getRowCount("Sheet1");	
	int totalcols=xlutil.getCellCount("Sheet1",1);
			
	String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
	
	for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
	{		
		for(int j=0;j<totalcols;j++)  //0    i is rows j is col
		{
			logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
		}
	}
	return logindata;//returning two dimension array
	}

	@DataProvider(name="CurrecyData")
	 public Object[] getDataCurrency(){
	        return new Object[]{
	                "USD","GBP","EUR"
	                
	        };
	    }
	
	@DataProvider(name="Payment")
	 public Object[][] getPayment(){
		
		Map<String, String> cheque = Maps.newHashMap();
		cheque.put("PayeeName", "1231231231");
		
		Map<String, String> paypal = Maps.newHashMap();
		paypal.put("paypalnum", "1231231231");
     
     
		
	        return new Object[][]{
	        	{"cheque",cheque},
	        	{"paypal",paypal}    
	        };
	    }
	
	
	
	
}
