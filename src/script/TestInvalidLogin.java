package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtility;
import page.LoginPage;

public class TestInvalidLogin extends BaseTest{
@Test(priority=2)

public void testInvalidLogin() throws InterruptedException {
	int rc= FWUtility.getXlRowCount(XL_PATH, "InvalidLogin");
	Reporter.log("RC:" + rc, true);
	for (int i= 1;i<=rc;i++) {
String un=FWUtility.getXlData(XL_PATH, "InvalidLogin", i, 0);
String pw= FWUtility.getXlData(XL_PATH, "InvalidLogin", i, 1);

//Enter Valid Username
LoginPage l= new LoginPage(driver);
l.setUserName(un);
//enter password
l.setPassword(pw);
//click on login button
l.clickLogin();
//verify ErrorMsg is displayed
Thread.sleep(2000);
l.verifyErrMSgIsDisplayed();
Assert.fail();

}
}

}
