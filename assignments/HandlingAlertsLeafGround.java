package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlertsLeafGround {

	public static void main(String[] args) throws InterruptedException {
		// Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Launch URL
		driver.get("https://www.leafground.com/alert.xhtml");
		//String mainwindow = driver.getWindowHandle();

		// Simple Dialog
		driver.findElement(By.xpath("(//span[@class=\"ui-button-text ui-c\"])[1]")).click();
		Alert simplealert = driver.switchTo().alert();
		simplealert.accept();
		System.out.println("Simple Alert: " + driver.findElement(By.xpath("//span[@id=\"simple_result\"]")));

		// Alert Confirmation
		driver.findElement(By.xpath("(//span[@class=\"ui-button-text ui-c\"])[2]")).click();
		Alert confirmalert = driver.switchTo().alert();
		confirmalert.accept();
		System.out.println("Alert Confirmation: " + driver.findElement(By.xpath("//span[@id=\"result\"]")));

		// Sweet Alert (Simple Dialog)
		driver.findElement(By.xpath("(//span[@class=\"ui-button-text ui-c\"])[3]")).click();
		System.out.println("Message: " + driver.findElement(By.xpath("//p[contains(text(),'You have clicked and open a dialog that can be inspectable')]")).getText());
		driver.findElement(By.xpath("//span[contains(text(),'Dismiss')]")).click();
		System.out.println("Alert Confirmation: " + driver.findElement(By.xpath("//span[@id=\"result\"]")));

		// Sweet Modal Dialog
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@name='j_idt88:j_idt100']//span)[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();

		// Alert With Prompt
		driver.findElement(By.xpath("(//span[@class=\"ui-button-text ui-c\"])[6]")).click();
		Alert promptalert = driver.switchTo().alert();
		promptalert.sendKeys("Priya");
		promptalert.accept();
		System.out.println("Prompt Alert Message: " + driver.findElement(By.xpath("//span[@id=\"confirm_result\"]")).getText());

		// Sweet Alert Confirmation Dialog
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		
		// Minimize & Maximize
		driver.findElement(By.xpath("(//span[@class=\"ui-button-text ui-c\"])[8]")).click();
		driver.findElement(By.xpath("//a[@class=\"ui-dialog-titlebar-icon ui-dialog-titlebar-maximize ui-corner-all\"]")).click();
		driver.findElement(By.xpath("(//a[@aria-label=\"Close\"])[3]")).click();
		
		//driver.close();
	}

}
