package week5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonAction {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.manage().window().maximize();
      //loading url 
      driver.get("https://www.amazon.in/");
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("OnePlus 9 Pro ");
      //action obj initiation
Actions act= new Actions(driver);
      WebElement element = driver.findElement(By.id("nav-search-submit-button"));
      act.click(element).perform();
      String text = driver.findElement(By.xpath("//span[text()='24,599']")).getText();
      System.out.println(text);
      String text2 = driver.findElement(By.xpath("//span[text()='7']")).getText();
      System.out.println(text2);
      WebElement element2 = driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]"));
      act.moveToElement(element2).perform();
      act.click(element2).perform();
      //getting window handle
      Set<String> windowHandles = driver.getWindowHandles();
      System.out.println(windowHandles);
      List<String> childwindow = new ArrayList<String>(windowHandles);

      driver.switchTo().window(childwindow.get(1));
      Thread.sleep(2000);
      //Screenshot initiation 
      File source = driver.getScreenshotAs(OutputType.FILE);
      File dest = new File("./Snaps/product.png");
      FileUtils.copyFile(source, dest);
      WebElement element3 = driver.findElement(By.id("add-to-cart-button"));
      act.moveToElement(element3).perform();
      act.click(element3).perform();
      Thread.sleep(2000);
      String text3 = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
      System.out.println(text3);
      driver.close();
	}
	}

