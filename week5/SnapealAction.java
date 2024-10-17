package week5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapealAction {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.manage().window().maximize();
    // loading url 
    driver.get("https://www.snapdeal.com/");
    // action class initiation
    Actions act = new Actions(driver);
    WebElement element = driver.findElement(By.xpath("//span[@class='catText']"));
	act.moveToElement(element).perform();
	WebElement element2 = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
	act.moveToElement(element2).perform();
	act.click(element2).perform();
	String text = driver.findElement(By.xpath("//span[text()[normalize-space()='( 6514 Items)']]")).getText();
	System.out.println(text);
	Thread.sleep(3000);
	//elements locating
	driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
	driver.findElement(By.xpath("//span[text()='Sort by:']/following-sibling::i")).click();
	driver.findElement(By.xpath("(//ul[@class='sort-value']//li)[2]")).click();
	WebElement element3 = driver.findElement(By.xpath("//input[@class='input-filter']"));
	element3.clear();
	element3.sendKeys("500");
	WebElement element4 = driver.findElement(By.name("toVal"));
	element4.clear();
	element4.sendKeys("700");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[text()[normalize-space()='GO']]")).click();
	//texts gathering 
	String text2 = driver.findElement(By.xpath("//a[@data-key='Price|Price']")).getText();
	System.out.println(text2);
	String text3 = driver.findElement(By.className("sort-selected")).getText();
	System.out.println(text3);
	WebElement element5 = driver.findElement(By.xpath("//p[text()='Combit PUNCH-04 Navy Blue Training Shoes']"));
	act.moveToElement(element5).perform();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
	String text4 = driver.findElement(By.xpath("//span[text()='505 ']")).getText();
	System.out.println(text4);
	String text5 = driver.findElement(By.xpath("//span[text()='72% Off']")).getText();
	System.out.println(text5);
	Thread.sleep(2000);
	// screenshot initiation
	File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	File dest = new File("./Snaps/shoes.png");
	FileUtils.copyFile(screenshotAs, dest);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[contains(@class,'close close1')]//i[1]")).click();
	driver.close();
	}

}
