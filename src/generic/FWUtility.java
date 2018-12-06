package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

public class FWUtility {
	public static String getXlData(String path, String sheet, int r, int c) {
		String v="";
		try {
			Workbook wb= WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e) {
			//e.printStackTrace();
		}
		return v;	
	}
	public static int getXlRowCount(String path, String sheet) {
		int count= 0;
		try {
			Workbook wb= WorkbookFactory.create(new FileInputStream(path));
			count=wb.getSheet(sheet).getLastRowNum();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public static void writeDataToXL(String path,String sheet,int r, int c,int v) {
		try {
			Workbook wb= WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(v);
			wb.write(new FileOutputStream(path) {
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void getPhoto(WebDriver driver, String path) {

		try {
			TakesScreenshot t= (TakesScreenshot)driver;
			File srcFile = t.getScreenshotAs(OutputType.FILE);
			File destFile=new File(path);
			FileUtils.copyFile(srcFile, destFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void scroll(WebElement element,WebElement eleHead, WebDriver driver) {
		int x=element.getLocation().getX();
		int y=element.getLocation().getY();
		int height=eleHead.getSize().getHeight();
		y=y-height;
		//Now Type-cast
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo("+x+","+y+")");
	}
	
}
