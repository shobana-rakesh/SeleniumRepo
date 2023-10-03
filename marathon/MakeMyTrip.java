package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTrip {
	
	public static void main(String[] args) {
		
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//open makemytrip website
		driver.get("https://www.makemytrip.com/");
		
		// Handle the browser notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//close the sweet alert
		//driver.findElement(By.xpath("//div[@class='loginSliderCompWrapper']")).clear();
		
		WebElement Element = driver.findElement(By.xpath("//span[@class='switcherDownArrow appendLeft10']"));
		Actions actions = new Actions(driver);

		//Hovering on main menu
		actions.moveToElement(Element).perform();
		
		//Click on the website logo
		//driver.findElement(By.xpath("//a[@class='mmtLogo makeFlex']")).click();
	}

}
