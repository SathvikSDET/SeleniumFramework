package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC004_DiseperItems {

	
	//https://bootstrapdemos.wrappixel.com/adminpro/dist/main/app-notes.html
	
	@Test
	void CountHowManyTiles() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://bootstrapdemos.wrappixel.com/adminpro/dist/main/app-notes.html");
		
		List<WebElement> elements = driver.findElements(By.xpath("//*[starts-with(@class,\"col-md-4\")]"));
		
		
		System.out.println("Number of notes");
		System.out.println(elements.size());
		int count =1;
		for (WebElement webElement : elements) {
			
			String text = webElement.getText();
			if(text.startsWith("Launch")) {
			 driver.findElement(By.xpath("//div[starts-with(@class,\"col-md-4\")]["+count+"]//a[@class =\"link me-1\"] ")).click();
			break;
			}
			count++;
			
		}
		
		
	}
}
