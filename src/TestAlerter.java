import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestAlerter {

	public static void main(String[] args) {
			
			System.out.println("Program begins");
			
			HtmlUnitDriver driver = new HtmlUnitDriver();
			
			// get to the "book a road test page"
			driver.get("https://drivetest.ca/book-a-road-test/booking.html#/validate-driver-email");
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			
			System.out.println(driver.getTitle() + "\n");
			System.out.println("Link opened successfully");
			
			//WebElement email = driver.findElement(By.id("emailAddress"));
			WebElement email = driver.findElement(By.name("emailAddress"));
			email.sendKeys("singh.rbir@gmail.com");
			
			WebElement confirmEmail = driver.findElement(By.id("confirmEmailAddress"));
			confirmEmail.sendKeys("singh.rbir@gmail.com");
			
		
	}

}