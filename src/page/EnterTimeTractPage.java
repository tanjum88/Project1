package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTractPage {
	@FindBy(xpath="//div[contains(text(),'Settings')]")
	 private WebElement settings;
	
	@FindBy(xpath="//a[.='Licenses']")
	private WebElement licenses;
	
public EnterTimeTractPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}
public void clickSettings() {
	settings.click();
}
public void clickLicenses() {
	licenses.click();
}
	
public void verifyHomePageIsDisplayed(WebDriver driver, long ETO, String eTitle) {
	WebDriverWait wait= new WebDriverWait(driver, ETO);
	wait.until(ExpectedConditions.titleIs(eTitle));
	String aTitle= driver.getTitle();
	Assert.assertEquals(aTitle, eTitle);
	System.out.println("The homepage title is "+aTitle);

}
}
