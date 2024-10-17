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

public class BigbasketAction {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
     driver.manage().window().maximize();
     // loading url
     driver.get("https://www.bigbasket.com/");
     driver.findElement(By.xpath("(//span[text()='Category'])[2]")).click();
     Thread.sleep(2000);
     Actions act = new Actions(driver);
     // action class process
     WebElement element = driver.findElement(By.linkText("Foodgrains, Oil & Masala"));
     act.moveToElement(element).perform();
WebElement element2 = driver.findElement(By.linkText("Rice & Rice Products"));
act.moveToElement(element2).perform();
 
driver.findElement(By.linkText("Boiled & Steam Rice")).click();
Thread.sleep(2000);
WebElement element3 = driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']"));
act.scrollToElement(element3).perform();
act.click(element3).perform();
//window handles
Set<String> windowHandles = driver.getWindowHandles();
System.out.println(windowHandles);

List<String> childwindow = new ArrayList<String>(windowHandles);

driver.switchTo().window(childwindow.get(1));
Thread.sleep(2000);
WebElement element4 = driver.findElement(By.xpath("//span[text()='5 kg']"));
act.scrollToElement(element4).perform();
act.click(element4).perform();
// text gathering
String text = driver.findElement(By.xpath("//td[text()='Price: ']")).getText();
System.out.println(text);
driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
String text2 = driver.findElement(By.xpath("//p[text()='An item has been added to your basket successfully']")).getText();
System.out.println(text2);
File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
File dest = new File("./Snaps/page.png");
FileUtils.copyFile(screenshotAs, dest);
Thread.sleep(2000);
driver.quit();

	}

}
