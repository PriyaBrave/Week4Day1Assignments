package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingLeafGround {

	public static void main(String[] args) {
		// Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Launch URL
		driver.get("https://www.leafground.com/window.xhtml");
		String mainwindow = driver.getWindowHandle();
		
		//Click and Confirm new Window Opens
		driver.findElement(By.xpath("//span[contains(text(),'Open')]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> newwindow = new ArrayList<String>(windows);
		
		WebDriver dashboardwindow = driver.switchTo().window(newwindow.get(1));
		
		System.out.println("Page Title: "+driver.getTitle());
		dashboardwindow.close();
		
		driver.switchTo().window(newwindow.get(0));
		
		//Closing all windows except Primary
		driver.findElement(By.xpath("//span[contains(text(),'Close Windows')]")).click();
		System.out.println("Page Title: "+driver.getTitle());
		
		for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(mainwindow)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
	    }
		driver.switchTo().window(newwindow.get(0));
		
		//Finding the number of Opened Tabs and printing the Titles
		driver.findElement(By.xpath("//span[contains(text(),'Open Multiple')]")).click();
		
		Set<String> windows1 = driver.getWindowHandles();
		ArrayList<String> newwindow1 = new ArrayList<String>(windows1);
		
		System.out.println("No. of Tabs Opened: "+newwindow1.size());
	
		for(String tab : newwindow1) {
			String title = driver.switchTo().window(tab).getTitle();
			System.out.println(title);
		}
		
		driver.switchTo().window(newwindow.get(0));
		
		driver.findElement(By.xpath("//span[contains(text(),'Open with delay')]")).click();
		Set<String> windows11 = driver.getWindowHandles();
		ArrayList<String> newwindow11 = new ArrayList<String>(windows11);
		
		for(String tab : newwindow11) {
			String title = driver.switchTo().window(tab).getTitle();
			System.out.println(title);
			driver.switchTo().window(tab).close();
		}
	
		driver.quit();
	}

}
