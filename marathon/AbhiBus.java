package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AbhiBus {
	
	public static void main(String[] args) throws InterruptedException{
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.abhibus.com/");
		driver.findElement(By.id("pills-home-tab")).click();
		//type chennai in from tex box
		driver.findElement(By.xpath("//input[@id='source']")).sendKeys("CHENNAI");
		//click the first option from the menu
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		//TYPE BLORE IN TO box
		driver.findElement(By.id("destination")).sendKeys("BANGALORE");
		//click the first option from the pop u menu
		driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
		//pick tomo date from date picker
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
		driver.findElement(By.xpath("//a[text()='31']")).click();
		//click on search 
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		//get the name of the first resulting bus
		String BusName = driver.findElement(By.xpath("//div[@class='search-column1']/h2")).getText();
		System.out.println("The Bus available: " +BusName);
		
		//click the sleeper menu on the left side
		driver.findElement(By.xpath("//input[@id='Bustypes4']")).click();
		
		//print the first resulting bus seat count
		String Seats = driver.findElement(By.xpath("//div[@class='search-column2-col1']/p")).getText();
	    System.out.println("The number of seats available: " +Seats);
	    
	    //choose select seat
	    driver.findElement(By.xpath("(//a[@class='btn-seatselect book1']//span[@class='book'])[1]")).click();
	    
	    //choose any available seat
	    driver.findElement(By.xpath("(//a[@class='tooltip tooltipstered']//span[@class='pillow'])[1]")).click();
	    
	    //print seat selected
	    String SelectedSeats = driver.findElement(By.xpath("//p[@class='right']//span[@id='seatnos']")).getText();
	    System.out.println("The selected Number is: " +SelectedSeats);
	    
	    //print total fare
	    String TotalFare = driver.findElement(By.xpath("//p[@class='right']//span[@id='ticketfare']")).getText();
	    System.out.println("The total fare of your travel: Rs." +TotalFare);
	    
	    Thread.sleep(2000);
	    //select boarding point
	    WebElement BoardingPoint = driver.findElement(By.className("dropdown_custom"));
	    Select sec = new Select(BoardingPoint);
	    sec.selectByIndex(4);
	    
	    //select dropping point
	    WebElement DroppingPoint = driver.findElement(By.className("dropdown_custom"));
	    Select sec1=new Select(DroppingPoint);
	    sec1.selectByIndex(11);
	    
	   //get the title of the page
	    String title = driver.getTitle();
	    System.out.println("The Title of the page: " +title);
	    
	    driver.close();
	    
	}
	
	
	

}
