package week5;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement element = driver.findElement(By.id("txtStationFrom"));
		element.clear();
		element.sendKeys("MAS");
		driver.findElement(By.xpath("//div[text()='Mgr Chennai Ctr']")).click();
		WebElement element2 = driver.findElement(By.id("txtStationTo"));
		element2.clear();
		element2.sendKeys("MDU");
		driver.findElement(By.xpath("//div[text()='Madurai Jn']")).click();
		driver.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='divTrainsList']/table/tbody/tr/td[2]"));
		for (int i = 0; i < elements.size()-1; i++) {
			System.out.println(elements.get(i).getText());
		
		if (elements.get(i).getText().equals(elements.get(i+1).getText())) {
			System.out.println(elements.get(i));
		}else
			System.out.println("no duplicates");
	}
		

}
}
