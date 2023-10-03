package marathon;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TatacliqTestcase {
	
	public static void main(String[] args) throws InterruptedException {
	
	
	// Handle the browser notifications
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	
	// Launch the browser
	
	ChromeDriver driver=new ChromeDriver(options);
	
	//maximise the window
	driver.manage().window().maximize();
	
	//// Add wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	// Load the url
			driver.get("https://www.tatacliq.com/");
			
	// Enter Watches & Accessories in search box
			//driver.findElement(By.xpath("//input[@id='search-text-input']")).sendKeys("Watches & Accessories",Keys.ENTER);
			
			// under Featured brands choose the first option
			// Locating the Main Menu (Parent element)
			WebElement mainMenu = driver.findElement(By.xpath("//div[contains(text(),'Brands')]"));
			
			
			//Instantiating Actions class
			Actions actions = new Actions(driver);

			//Hovering on main menu
			actions.moveToElement(mainMenu).perform();
			
			Thread.sleep(5000);

			// Locating the element from Sub Menu
			driver.findElement(By.xpath("//div[text()='Watches & Accessories']")).click();
			driver.findElement(By.xpath("(//div[@class='DesktopHeader__brandsDetails'])[5]")).click();
			
			//clear the filters
			driver.findElement(By.xpath("//span[text()='Clear All']")).click();
			
			//on dropdown sortby-select new arrivals
			WebElement newArrival = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		    Select sortBy = new Select(newArrival);
			
			sortBy.selectByVisibleText("New Arrivals");
			
			//check the checkbox men
			//driver.findElement(By.xpath("(//div[@class='FilterDesktop__newFilCheckbox'])[1]")).click();
			

			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[@id=\"filter-container\"]/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[1]/div")).click();
			
			
			
			
			
			//get the price of the watches
			List<WebElement> text = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3[@class='ProductDescription__boldText']"));
		      
			System.out.println(text.size());
		      
		      for (WebElement each : text) {
		    	  
		    	  System.out.println(each.getText());
				
			}
		      
		      //click second loaded result
		      
		      String text1 = driver.findElement(By.xpath("(//div[@class='ProductDescription__priceHolder']/h3[@class='ProductDescription__boldText'])[2]")).getText();
		     // String text1 = driver.findElement(By.xpath("(//div[@class='ProductDescription__priceHolder'])[3]")).getText();
		      
		      //print the watch price
		      
		      System.out.println("The price of the second loaded watch :" +text1);
		      
			//click the second loaded watch
		      driver.findElement(By.xpath("(//div[@class='ProductModule__dummyDiv'])[2]")).click();
		      
		      //handle the window
		      String pwindowHandle=driver.getWindowHandle();
			  ////get the title of the parent  window
				String pTitle=driver.getTitle();
				System.out.println(pTitle);
								
				//to get all window handles
				Set<String> windowHandles = driver.getWindowHandles();
				System.out.println(windowHandles);
						
				//to switch to child window
				List<String> handles=new ArrayList<>(windowHandles);
				driver.switchTo().window(handles.get(1));
				
				//get the title of the child window
				String cTitle=driver.getTitle();
				System.out.println(cTitle);
				
				Thread.sleep(2000);
				
				//print the price of the watch fro the new window opened
				String text2 = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText();
				
				System.out.println(text2);
				
				for (String compare : handles) {
					
					if(text1!=text2) {
						System.out.println("The price match");
						
					}else {
						System.out.println("The price is not matching");
					}
				}
					//click add to bag
					//driver.findElement(By.xpath("(//div[@class='ProductDescriptionPage__buttonAddToBag '])[2]")).click();
					driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
					//check the bag count
					
					driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getSize();
					
					//click the cart
					driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();
					
					
					 System.out.println("Page title is : " + driver.getTitle());
			
					
				//switch back to parent window
				driver.switchTo().window(handles.get(0));
				
				driver.quit();
				
}
}
				
		
			
			


