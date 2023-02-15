/**
 *****---**---**---**----*****
 * @author Alexander Yasheyev*
 *   QA Automation Engineer/  *
 *****---**---**---**----*****
 */
import java.io.IOException;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

//import net.jodah.failsafe.internal.util.RandomDelay;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class DemoTest {  

	final static String WEBSITENAME="https://yellow-forest-00099c403.2.azurestaticapps.net";
	
	public static void main(String[] args) throws IOException, InterruptedException
	{  
		DemoTest testing = new DemoTest();
		TestProcedures proc = new TestProcedures();
		
		int inum = 0;
		
		//open log file
		PrintWriter out = new PrintWriter("C:\\Users\\pjpro\\Desktop\\TestLogFile "+inum+".txt");
		
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\LEARNZONE\\ISTQB\\Selenium\\chromedriver_win32\\chromedriver.exe");  
		
		//Instantiate a ChromeDriver class.     
		WebDriver driver=new ChromeDriver();  
							
		//date and time printing
		LocalDateTime myDateObj = LocalDateTime.now();  
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		System.out.println(formattedDate+"\r\n");
		System.out.print("Links Test Started");
		out.write(formattedDate+"\r\nLinks Testing of WebSite: "+ WEBSITENAME+" is Started");
		
		// Launch Website 
		driver.navigate().to(WEBSITENAME);
		driver.manage().window().maximize();
		
		//login
		Login loginObj = new Login();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/button[1]/*[name()='svg'][1]")).click();
		driver.findElement(By.name("email")).sendKeys(loginObj.getMail());
		driver.findElement(By.name("password")).sendKeys(loginObj.getPass());
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		
		//Printing name and launch status + write to log file
		inum++;
		out.write("\r\nstep --"+inum+ "-- Success");//open web site
		System.out.println("step --"+inum+"-- Success");
				
		boolean result = true;
		Thread.sleep(10000);
		Gdudim2 gdudimTest = new Gdudim2(inum, driver, out);
		result = gdudimTest.Test();
		
		//Get title
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--lang= locale-of-choice");
//		String title = driver.getTitle();
//		System.out.println(title);
		

		if (result) 
		{
			System.out.println("Succesful Test - All Links work");
			out.append("\r\nSuccesful Test - All Links work");
		}
		else 
		{
			System.out.println("Test Failure -  some link do not work");
			out.append("\r\nTest Failure -  some link do not work");
		}
		out.close();
	}  
}  