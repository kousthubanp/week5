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
import org.openqa.selenium.support.ui.Select;

public class TataCliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
     driver.manage().window().maximize();
     //loading url
     driver.get("https://www.tatacliq.com/");
     driver.findElement(By.xpath("//button[text()='Ask Me Later']")).click();
     Actions act = new Actions(driver);
     WebElement element = driver.findElement(By.xpath("//div[text()='Brands']"));
     act.moveToElement(element).perform();
     Thread.sleep(5000);
   //selecting webelement
     WebElement element2 = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
     act.moveToElement(element2).perform();
     driver.findElement(By.xpath("//div[text()='Casio']")).click();
     WebElement popularityPriceLowTo = driver.findElement(By.tagName("select")); 
     new Select(popularityPriceLowTo).selectByIndex(3); 
     WebElement element3 = driver.findElement(By.xpath("//div[text()='Men']"));
     act.moveToElement(element3).perform();
     Thread.sleep(2000);
     act.click(element3).perform();
     //getting all price
    List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']"));
     System.out.println(elements.size());
     for (int i = 0; i <= elements.size()-1; i++) {
    	String text = elements.get(i).getText();
		 		System.out.println(text);	 		
	}
     Thread.sleep(5000);
     driver.findElement(By.xpath("//div[@class='ProductModule__dummyDiv']")).click();
   //window handle initiating
     Set<String> windowHandles = driver.getWindowHandles();
     System.out.println(windowHandles);
     List<String> childwindow = new ArrayList<String>(windowHandles);
     driver.switchTo().window(childwindow.get(1));
     WebElement element4 = driver.findElement(By.xpath("(//div[@class='Button__base'])[3]"));
     act.moveToElement(element4).perform();
     act.click(element4).perform();
     //getting text
     String text2 = driver.findElement(By.xpath("//span[text()='1']")).getText();
     System.out.println(text2);
     Thread.sleep(3000);
     String text3 = driver.findElement(By.xpath("//h3[text()='MRP:  ₹3995']")).getText();
     System.out.println(text3);
     driver.findElement(By.className("DesktopHeader__myBagShow")).click();
     String text4 = driver.findElement(By.className("CartItemForDesktop__informationTextWithBolder")).getText();
     System.out.println(text4);
     //taking screenshot
     File source = driver.getScreenshotAs(OutputType.FILE);
     File dest = new File("./Snaps/bag.png");
     FileUtils.copyFile(source, dest);
     driver.quit();
     
	}


}
