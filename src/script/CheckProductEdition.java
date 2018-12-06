package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtility;
import page.EnterTimeTractPage;
import page.LicensePage;
import page.LoginPage;

public class CheckProductEdition extends BaseTest {
	
	@Test(priority=4)
	
	public void testCheckProductEdition() throws Exception{
		String un = FWUtility.getXlData(XL_PATH, "CheckProductEdition", 1, 0);
		String pw = FWUtility.getXlData(XL_PATH, "CheckProductEdition", 1, 1);
		String productEdition = FWUtility.getXlData(XL_PATH, "CheckProductEdition", 1, 2);
		
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
	e.clickLicenses();
	
	//verify Issue Date
	LicensePage c= new LicensePage(driver);
	c.verifyProductEdition(productEdition);
	
	//click Logout
	c.clickLogout();
	
	}

}
