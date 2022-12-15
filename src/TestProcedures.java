/**
 *****---**---**---**----*****
 * @author Alexander Yasheyev*
 *   QA Automation Engineer  *
 *****---**---**---**----*****
 */
import java.io.PrintWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class TestProcedures {
	/**
	 * tests single link
	 * @param xpath
	 * @param testNum
	 * @param out
	 * @param driver
	 * @return
	 */
	public boolean testSingleLink(String xpath, int testNum, PrintWriter out, WebDriver driver)
	{
		boolean result = true;
		String printStr;
		try
		{
			result = driver.findElement(By.xpath(xpath)) != null;
			if (result)
				driver.findElement(By.xpath(xpath)).click();

			printStr = "step --"+testNum+ "-- Success = " + result;
		}
		catch(Exception ex)
		{
			printStr = "step --" +testNum+ "-- Failure - link does not work: " + xpath;
			result = false;
		}

		System.out.println(printStr);
		out.write("\r\n"+printStr);

		return result;
	}
	/**
	 * 
	 * @param xpath
	 * @param testNum
	 * @param out
	 * @param driver
	 * @return
	 */
	public boolean testSendKeys(String xpath, int testNum, PrintWriter out, WebDriver driver)
	{
		boolean result = true;
		String printStr="";
		try
		{
			result = driver.findElement(By.xpath(xpath)) != null;
			if (result)
			{
				for (int i=0; i<StringsTestList.DifferentChars.length; i++)
				{
					driver.findElement(By.xpath(xpath)).sendKeys(StringsTestList.DifferentChars[i]);
					printStr = "step --"+testNum+ ":" + i + "-- Success = " + result + " with str="+ StringsTestList.DifferentChars[i];
					System.out.println(printStr);
					out.write("\r\n"+printStr);
				}
			}
		}
		catch(Exception ex)
		{
			printStr = "step --" +testNum+ "-- Failure - link does not work: " + xpath + " exception: " + ex.getMessage();
			System.out.println(printStr);
			out.write("\r\n"+printStr);
			result = false;
		}
		return result;
	}
}
