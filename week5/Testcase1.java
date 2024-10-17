package week5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
//testng process
public class Testcase1 extends ProjectSpecificMethod {
@Test
	public  void runtestcase1() throws InterruptedException {
	driver.findElement(By.xpath("//div[@class='slds-r8']/following-sibling::div[1]")).click();
	driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
	Thread.sleep(5000);
	// action class processing
	Actions act= new Actions(driver);
WebElement element = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
act.scrollToElement(element).perform();
act.click(element).perform();		
Thread.sleep(3000);
// elements gathering
   driver.findElement(By.xpath("//a[@title='Legal Entities']/following::a[1]")).click();	
    WebElement element2 = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
    act.moveToElement(element2).perform();
    act.click(element2).perform();
    
    driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Salesforce Automation by Kousthu");
    driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
    String text = driver.findElement(By.xpath("//lightning-formatted-text[@data-output-element-id='output-field']")).getText();
   System.out.println(text);
}

}
