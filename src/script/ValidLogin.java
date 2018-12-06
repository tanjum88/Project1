package script;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtility;
import page.EnterTimeTractPage;
import page.LoginPage;

public class ValidLogin extends BaseTest{
@Test(priority=1)

public void testValidLogin() throws InterruptedException {
String un=FWUtility.getXlData(XL_PATH, "ValidLogin", 1, 0);
String pw= FWUtility.getXlData(XL_PATH, "ValidLogin", 1, 1);
String title=FWUtility.getXlData(XL_PATH, "ValidLogin", 1, 2);

//Enter Valid Username
LoginPage l= new LoginPage(driver);
l.setUserName(un);
//enter password
l.setPassword(pw);
//click on login button
l.clickLogin();
//verify homepage is displayed
EnterTimeTractPage e=new EnterTimeTractPage(driver);
e.verifyHomePageIsDisplayed(driver, ETO, title);
}

}
