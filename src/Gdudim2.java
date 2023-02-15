
import java.io.PrintWriter;
import org.openqa.selenium.WebDriver;
/**
 * 1
 * @author pjpro
 *
 */
public class Gdudim2 {
	
	int _inum = 0;
	WebDriver _driver=null;
	PrintWriter _logFile = null;
	TestProcedures _proc = null;
	
	final String _buttonXpath = "//html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/button[1]";
	final String _buttonSaveXpath = _buttonXpath;
	final String _inputsXpath1 = "//input[@name='";
	final String _inputsXpath2 = "'";
//	final String _shahar = "//input[@name='shahar']";
//	final String _kedem = "//input[@name='kedem']";
//	final String _tavor = "//input[@name='tavor']";
//	final String _ram = "//input[@name='ram']";
	
	String[] strArray = {"shahar", "kedem", "tavor", "ram"};
	
	
	
	
	public Gdudim2(int num, WebDriver driver, PrintWriter logFile)
	{
		_inum = num;
		_driver = driver;
		_logFile = logFile;
		_proc = new TestProcedures();
	}
	
	
	
	public boolean Test() {

		boolean result = true;

		_inum++;
//		result = _proc.testSingleLink(_buttonXpath, _inum, _logFile, _driver);
		if(result) {
			for (int i = 1; i <= 4; i++)
			{
				_inum++;
				result = _proc.testSendKeys(_inputsXpath1 + strArray[0] + _inputsXpath2, _inum, _logFile, _driver) && result;
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
