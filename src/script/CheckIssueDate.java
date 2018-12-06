package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtility;
import page.EnterTimeTractPage;
import page.LicensePage;
import page.LoginPage;

public class CheckIssueDate extends BaseTest {
	@Test(priority=3)
	
	public void testCheckIssueDate() throws Exception {
		String un = FWUtility.getXlData(XL_PATH, "CheckIssueDAte", 1, 0);
		String pw = FWUtility.getXlData(XL_PATH, "CheckIssueDAte", 1, 1);
		String issueDate = FWUtility.getXlData(XL_PATH, "CheckIssueDAte", 1, 2);
		
		//Enter valid UserName
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		//Enter Valid Password
		l.setPassword(pw);
		//ClickLogin 
		l.clickLogin();
		Thread.sleep(2000);
		
		//clickSettings
		EnterTimeTractPage e= new EnterTimeTractPage(driver);
		e.clickSettings();
		Thread.sleep(2000);
		e.clickLicenses();
		
		//verify Issue Date
		LicensePage c= new LicensePage(driver);
		Thread.sleep(5000);
		c.verifyIssueDate(issueDate);
		
		Thread.sleep(2000);
	
		//click Logout
		c.clickLogout();
	
		
		
	}

}
