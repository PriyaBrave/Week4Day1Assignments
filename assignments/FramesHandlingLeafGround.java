package week4.day1.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandlingLeafGround {

	public static void main(String[] args) {
		// Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Launch URL
		driver.get("https://www.leafground.com/frame.xhtml");
		
		driver.getWindowHandle();

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@id=\"Click\"]")).click();

		String insideframe = driver.findElement(By.xpath("//button[contains(text(),'Hurray!')]")).getText();
		System.out.println("Clicking Inside Frame: " + insideframe);
		
		driver.switchTo().parentFrame();
		
		// Counting Frames
		//driver.findElement(By.xpath("//button[contains(text(),'Count Frames')]")).click();
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.xpath("//iframe"));
		System.out.println("Total number " + frames.size());
		for (WebElement fr : frames) {
			System.out.println("Frames: "+fr);
		}
		
		driver.switchTo().parentFrame();
		
		// Nested Frame
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//button[contains(text(),'Click Me')]")).click();
		String nestedframe = driver.findElement(By.xpath("//button[contains(text(),'Hurray!')]")).getText();
		System.out.println("Nested Frame: " + nestedframe);
		
		System.out.println(driver.getTitle());
	}

}
