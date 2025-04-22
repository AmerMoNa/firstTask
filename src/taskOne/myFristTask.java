package taskOne;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myFristTask {
	
	WebDriver driver = new EdgeDriver();
	String URL = "https://www.saucedemo.com/";

	String userName = "standard_user";
	String passWord = "secret_sauce";

	@BeforeTest
	public void first() {

		driver.get(URL);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void logIn() {
		WebElement userNameInput = driver.findElement(By.id("user-name"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement button = driver.findElement(By.id("login-button"));

		userNameInput.sendKeys(userName);
		passwordInput.sendKeys(passWord);
		button.click();

	}

	@Test(priority = 2)
	public void printDescripsion() {
		
		
		// print the elements dont have a number 3
		List<WebElement> descri = driver.findElements(By.className("inventory_item_desc"));
		
		
				
		for (int i=0 ; i<descri.size();i++ ) {
			
			String conditionWithout3 = descri.get(i).getText();
			
			if (conditionWithout3.contains("3")) {
				
				continue;
				
				
			}else {
				
				System.out.println(conditionWithout3);
			}
			
			
			
			
		}

		
	}
	


	@AfterTest
	public void logOut() {
		
		driver.quit();

	}

}
