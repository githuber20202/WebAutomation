/**
 *****---**---**---**----*****
 * @author Alexander Yasheyev*
 *   QA Automation Engineer  *
 *****---**---**---**----*****
 */
import java.io.IOException;
import java.io.PrintWriter;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DemoTest {  

	final static String WEBSITENAME="https://yellow-forest-00099c403.2.azurestaticapps.net";
	
	public static void main(String[] args) throws IOException
	{  
		DemoTest testing = new DemoTest();
		TestProcedures proc = new TestProcedures();
		
		int inum = 0;
		
		//open log file
		PrintWriter out = new PrintWriter("C:\\Users\\pjpro\\Desktop\\TestLogs"+inum+".txt"); 
		
		// System Property for Chrome Driver    
		System.setProperty("webdriver.chrome.driver", "C:\\LEARNZONE\\ISTQB\\Selenium\\chromedriver_win32\\chromedriver.exe");  
		
		//Instantiate a ChromeDriver class.     
		WebDriver driver=new ChromeDriver();  
						
		//date and time
		LocalDateTime myDateObj = LocalDateTime.now();  
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		String formattedDate = myDateObj.format(myFormatObj);  

		// Launch Website 
		driver.navigate().to(WEBSITENAME);
		driver.manage().window().maximize();
		
		//Printing name and launch status + write to log file
		inum++;
		System.out.println(formattedDate+"\r\nLinks Test Started");
		out.write(formattedDate+"\r\nLinks Testing of WebSite: "+ WEBSITENAME+" is Started!!");
		out.write("\r\nstep --"+inum+ "-- Success");//open web site
		System.out.println("step --"+inum+"-- Success");

		boolean result = true;
		
		Gdudim gdudimTest = new Gdudim(inum, driver, out);
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
