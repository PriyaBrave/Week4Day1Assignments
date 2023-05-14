package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Launch URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		// UserName & Password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Log In Button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		// Click on Leads Tab
		driver.findElement(By.linkText("Leads")).click();

		// Click on Merge Lead
		driver.findElement(By.linkText("Merge Leads")).click();

		// From
		driver.findElement(By.xpath("//input[@id=\"partyIdFrom\"]/following::a")).click();

		Set<String> windowset = driver.getWindowHandles();
		ArrayList<String> windowlist = new ArrayList<String>(windowset);
		
		WebDriver windowfromlead = driver.switchTo().window(windowlist.get(1));
		System.out.println("Title: "+windowfromlead.getTitle());
		windowfromlead.findElement(By.xpath("//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a")).click();
		
		driver.switchTo().window(windowlist.get(0));
		
		// To
		driver.findElement(By.xpath("//input[@id=\"partyIdTo\"]/following::a")).click();
		Set<String> windowset1 = driver.getWindowHandles();
		ArrayList<String> windowlist1 = new ArrayList<String>(windowset1);
		WebDriver windowtolead = driver.switchTo().window(windowlist1.get(1));
		Thread.sleep(2000);
		System.out.println("Title: "+windowtolead.getTitle());
		Thread.sleep(1000);
		windowtolead.findElement(By.xpath("(//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a) [2]")).click();
		//driver.close();
		Thread.sleep(1000);
		driver.switchTo().window(windowlist1.get(0));
		
		driver.findElement(By.xpath("//a[@class=\"buttonDangerous\"]")).click();
		
		Alert mergealert = driver.switchTo().alert();
		mergealert.accept();
		//System.out.println("Page Title: "+driver.getTitle());
		driver.switchTo().parentFrame();
		System.out.println("Page Title: "+driver.getTitle());
		Thread.sleep(1000);
		String verify = driver.findElement(By.xpath("//span[@id=\"viewLead_firstName_sp\"]")).getText();
		System.out.println("Verification; "+verify);
		System.out.println("Page Title: "+driver.getTitle());
	}
}
