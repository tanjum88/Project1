package generic;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConstant {
	public WebDriver driver;
	static {
		System.setProperty(CHROME_KEY,CHROME_VALUE);
	}
	@BeforeMethod
	public void openBrowser() {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(URL2);
		
	}
	public static int passCount=0,failCount=0;
	@AfterMethod
	public void closeBrowser(ITestResult result) {
		int status= result.getStatus();
		String testName = result.getName();
		
				if (status==1) {
					passCount++;
				}
				else {
					failCount++;
		Date d=new Date();
		String dateTime = d.toString().replaceAll(":", "-");
		String path=PHOTO_PATH+testName+"/"+dateTime+".png";
		Reporter.log("PHOTOPATH:"+ path, true);
		FWUtility.getPhoto(driver, path);
		}
				//jjjll
		driver.close();
	}
	
	@AfterSuite
	
	public void print() {
		Reporter.log("pass: "+ passCount, true);
		Reporter.log("fail: "+ failCount, true);
		FWUtility.writeDataToXL(REPORT_PATH, "sheet1", 1, 0, passCount);
		FWUtility.writeDataToXL(REPORT_PATH, "sheet1", 1, 1, failCount);
	}
}
