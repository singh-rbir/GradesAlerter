/*
 * ABOUT THIS PROJECT:
 *  This is a casual java program that pulls data from the York University's
 *  "Courses and Grades List" webpage on the Registrar's website.
 *  It takes the student's Passport York login (username & password), reads the courses
 *  and grades from the webpage and prints them out to the console.
 *
 *  I did not do any further development on this project because,
 *  no student would ever trust/type their university login credentials to a
 *  third-party application that is not released/governed by York University.
 *
 *  Initially the idea was to create an app out of it, that would take the student's
 *  university login once, and then would notify the student when new grades
 *  for any courses have been posted on the grades page. Inspiration behind it was to
 *  avoid repitition and automate this process of checking if any new grades have been posted. For those
 *  students who eagerly wait for their grades after the exams, and have to go to the
 *  univs' website and login again and again, to check grades, only to find out
 *  they haven't been posted yet(because they never release on time).
 *  The goal of this app would be to automate that process of opening the browser,
 *  typing in the url, typing in the username and password, and then checking for grades. Whereas, this app would
 *  do all that on it's own, check regulary and do all that in the background so
 *  that the user doesn't have to worry about having to keep checking in, repeatedly.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.By.ByLinkText;

public class GradesAlert {

	public static void main(String[] args) {

		System.out.println("Hello");

		HtmlUnitDriver driver = new HtmlUnitDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// get the Yorku Courses and Grades link webpage
		driver.get("https://wrem.sis.yorku.ca/Apps/WebObjects/ydml.woa/wa/DirectAction/document?name=CourseListv1");

		// Test print command
		System.out.println("Link opened successfully.");

		// send in the user name and password, and submit the form
		WebElement username = driver.findElement(By.id("mli"));
		username.sendKeys("YOUR PASSPORT YORK USERNAME HERE"); // passport york username as a string
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.sendKeys("YOUR PASSWORD HERE"); // password as a string
		pwd.submit();

		System.out.println(driver.getTitle().toUpperCase() + "\n");

//		WebElement table = driver.findElementByTagName("table");
//		System.out.println(table + "\n");

		// get the pointer to the courses & grades table
		WebElement gradesTable = driver.findElementByXPath("/html/body/form/center/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody");

		// get every table row as a WebElement (<tr> tag in html)
		List<WebElement> coursesArray = new ArrayList<>();
		coursesArray = gradesTable.findElements(By.tagName("tr"));

		// print every table row (Session + Course + Title + Grade) on a new line
		for(WebElement e: coursesArray) {
			System.out.println(e.getText() + "\n");
		}


		driver.quit();
		System.out.println("Driver has stopped.");

		//WebElement gradesLink = driver.findElement(By.partialLinkText("Course and grade list"));
		//gradesLink.submit();
		//homePage();
	}


}
