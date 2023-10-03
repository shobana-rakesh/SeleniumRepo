package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	
	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		
		// Load the url
		driver.get("https://www.ebay.com.au/");
		
		//maximise the window
		driver.manage().window().maximize();
		
		//// Add wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/a"));
		
		//WebElement mainMenu = driver.findElement(By.xpath("//div[@class='cb9A6G Vht1rO']"));
		////div[@class='cb9A6G Vht1rO']
		//Instantiating Actions class
		Actions actions = new Actions(driver);

		//Hovering on main menu
		actions.moveToElement(mainMenu).perform();

	}

}
