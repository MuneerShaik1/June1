package com.Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Testbase;

public class Utils extends Testbase {
	public Utils() throws Throwable {
		super();

	}

	public static void actionMethods(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).click().perform();
	}
public Object[][] ReaddataFromExcel(String sheetname) throws Throwable {
	File fi=new File("./src/main/java/com/testdata/Book11");
	FileInputStream stream=new FileInputStream(fi);
	XSSFWorkbook wrkbk=new XSSFWorkbook(stream);
	XSSFSheet sheet = wrkbk.getSheet(sheetname);
	int rownum = sheet.getPhysicalNumberOfRows();
	            int celnum = sheet.getRow(1).getLastCellNum();
	           Object[][] data=new Object[rownum-1][celnum];
	           for(int i=0;i<rownum-1;i++) {
	        	   for(int j=0;j<celnum;j++) {
	        		   DataFormatter df=new DataFormatter();
	        		  data[i][j]= df.formatCellValue(sheet.getRow(i+1).getCell(j));
	        	   }
	        	 
	           }
			return data;
	
}
	public static Object[][] ReadDataFromExcel(String sheetname) throws Throwable {
		File file1 = new File("./src/main/java/com/base/Book 5.xlsx");

		FileInputStream stream = new FileInputStream(file1);
	//	XSSFWorkbook wrkbk = new XSSFWorkbook(stream);

		XSSFWorkbook workbook = new XSSFWorkbook(stream);

		XSSFSheet sheet = workbook.getSheet(sheetname);

		int rownum = sheet.getPhysicalNumberOfRows();

		int cellnum = sheet.getRow(1).getLastCellNum();

		Object[][] data = new Object[rownum - 1][cellnum];

		for (int i = 0; i < rownum - 1; i++) {

			for (int j = 0; j < cellnum; j++) {

				DataFormatter df = new DataFormatter();

				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));

			}

		}
		return data;
	}

	public static void selectvalue(WebElement xpath, String value) {

		Select dropdown = new Select(xpath);
		dropdown.selectByValue(value);

	}

	// select dropdown by value
	public static void dropdown(WebElement wb, String value) {
		Select s = new Select(wb);
		s.selectByValue(value);
	}

	// select dropdown by index
	public static void dropdown(WebElement wb, int index) {
		Select s = new Select(wb);
		s.selectByIndex(index);
	}

	// select dropdown by visible text
	public static void dropdownBy(String text, WebElement wb) {
		Select s = new Select(wb);
		s.selectByVisibleText(text);
	}

	public static void moveToElement(WebElement wb) {
		Actions act = new Actions(driver);
		act.moveToElement(wb).click().perform();
	}

	public static void waitForElement(WebElement wb) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(wb));

	}

	public static void fileupload(String fpath) throws AWTException {

		StringSelection path = new StringSelection(fpath);// select
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		Robot r = new Robot();
		r.delay(3000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
//	File fi=new File("./src/main/java/com/testdata/Book_testng-task-1.xlsx");