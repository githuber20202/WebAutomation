import java.io.PrintWriter;

import org.openqa.selenium.WebDriver;

/**
 * 
 * @author pjpro
 *
 */
public class Gdudim {
	
	int _inum = 0;
	WebDriver _driver=null;
	PrintWriter _logFile = null;
	TestProcedures _proc = null;
	
	final String _buttonXpath = "//*[@id=\"container\"]/div[3]/button";
	final String _buttonSaveXpath ="//*[@id=\"container\"]/div[3]/form/button";
	final String _inputsXpath1 = "//*[@id=\"container\"]/div[3]/form/div/div[";
	final String _inputsXpath2 = "]/input";
	
	public Gdudim(int num, WebDriver driver, PrintWriter logFile)
	{
		_inum = num;
		_driver = driver;
		_logFile = logFile;
		_proc = new TestProcedures();
	}
	
	
	public boolean Test() {

		boolean result = true;

		_inum++;
		result = _proc.testSingleLink(_buttonXpath, _inum, _logFile, _driver);
		if(result) {
			for (int i = 1; i <= 4; i++)
			{
				_inum++;
				result = _proc.testSendKeys(_inputsXpath1 + i + _inputsXpath2, _inum, _logFile, _driver) && result;
			}
			_inum++;
			result = _proc.testSingleLink(_buttonSaveXpath, _inum, _logFile, _driver) && result;
		}
	
		if (result) 
		{
			System.out.println("Gdudim Succesful Test - All Links work");
			_logFile.append("\r\nGdudim Succesful Test - All Links work");
		}
		else 
		{
			System.out.println("Gdudim Test Failure -  some link do not work");
			_logFile.append("\r\nGdudim Test Failure -  some link do not work");
		}
		
		return result;
	}
}
