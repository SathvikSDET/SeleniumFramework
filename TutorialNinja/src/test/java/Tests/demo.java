package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo");
		List<WebElement> prices = driver.findElements(By.xpath("//div[@id='content']//p//span"));

		prices.stream()
		  .map(WebElement::getText)  
	      .filter(i -> !i.startsWith("Ex"))
	      .filter(i -> i.startsWith("$"))
	      .forEach(System.out::println); 
	}

}
