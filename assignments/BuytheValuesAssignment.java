package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuytheValuesAssignment {

	public static void main(String[] args) throws InterruptedException {
		// Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Launch URL
		driver.get("https://buythevalue.in/");
		// String mainwindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//div[@class='hxt-spm-clickable']//div")).click();
		
		//Clicking on the first product
		driver.findElement(By.xpath("(//div[@class=\"product-content\"]//a)[1]")).click();
		
		driver.switchTo().frame("dummy-chat-button-iframe");
		//Clicking on Chat
		driver.findElement(By.xpath("//button[@id=\"dummy-chat-button\"]")).click();
		driver.switchTo().frame("ShopifyChat");
		//Closing Chat
		driver.findElement(By.xpath("//button[@aria-label=\"Chat window\"]")).click();
		
		driver.switchTo().defaultContent();
		
		//Entering Pincode and Clicking on "Check" Button
		driver.findElement(By.xpath("//input[@id=\"wk_zipcode\"]")).sendKeys("600010");
		driver.findElement(By.xpath("//input[@value=\"Check\"]")).click();
		
		//Verification
		String availmsg = driver.findElement(By.xpath("//div[@class=\"wk_availability_msg\"]")).getText();
		System.out.println("Availability Message: "+availmsg);
		System.out.println(driver.getTitle());
		
		//Thread.sleep(2000);
		//Clicking Add to Cart
		driver.findElement(By.xpath("//button[@id=\"product-add-to-cart\"]")).click();
		
		//Thread.sleep(1000);
		//Clicking on View Cart
		driver.findElement(By.xpath("(//a[@href='/cart'])[3]")).click();
		
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//span[text()='View Cart']")).click();
		
		//Clicking on Check Out
		driver.findElement(By.xpath("//input[@id=\"checkout\"]")).click();
		
		//Handling Alert
		Alert checkoutalert = driver.switchTo().alert();
		checkoutalert.accept();
		
		//Selecting "Agree" Check Box
		driver.findElement(By.xpath("//input[@id=\"agree\"]")).click();
		
		//Again Clicking on "Check Out
		driver.findElement(By.xpath("//input[@id=\"checkout\"]")).click();
		System.out.println(driver.getTitle());
		
	}

}
