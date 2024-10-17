package week5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethod {
public ChromeDriver driver;
// before method creating
@BeforeMethod
	public void preCondition() {
		 driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("leaf@2024 ");
		driver.findElement(By.id("Login")).click();
	}
//after method creating
 @AfterMethod
	public void postCondition() {

		driver.close();
	}

}


