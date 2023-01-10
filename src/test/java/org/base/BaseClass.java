package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void LaunchUrl(String e) {
		driver.get(e);
	}

	public void windowMaximize() {
		driver.manage().window().maximize();
	}

	public void CloseBrowser() {
		driver.close();
	}

	public void passText(String s, WebElement e) {
		WebElement pass = driver.findElement(null);
		e.sendKeys(null);

	}

	private void clickBtn() {
		WebElement click = driver.findElement(null);
		click.click();
	}

	public static void createNewExcelFile(int rowNum, int cellNum, String newData) throws IOException {

		File f = new File("C:\\Users\\91848\\eclipse-workspace\\MavenProject\\Excel\\newFile.xlsx");
		Workbook wb = new XSSFWorkbook();
		Sheet createSheet = wb.createSheet("Datas");
		Row createRow = createSheet.createRow(rowNum);
		Cell createCell = createRow.createCell(cellNum);
		createCell.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

	public static void createRow(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\91848\\eclipse-workspace\\MavenProject\\Excel\\newFile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Datas");
		Row r = sheet.createRow(rowNum);
		Cell c = r.createCell(cellNum);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

	public static void createCell(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\91848\\eclipse-workspace\\MavenProject\\Excel\\newFile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Datas");
		Row r = sheet.getRow(rowNum);
		Cell c = r.createCell(cellNum);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void updateDataToParticularCell(int getTheRow, int getTheCell, String exitingData,
			String writeNewData) throws IOException {

		File f = new File("C:\\Users\\91848\\eclipse-workspace\\MavenProject\\Excel\\newFile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Datas");
		Row r = sheet.getRow(getTheCell);
		Cell c = r.getCell(getTheCell);
		String str = c.getStringCellValue();
		if (str.equals(exitingData)) {
			c.setCellValue(writeNewData);
		}

		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

}