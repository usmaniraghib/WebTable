package com.raghib.selenium.dynamicwebtable;

import java.time.Duration;

//NOTE :- Try to type one import statement then only import reference will be provided by eclipse.

/*
* REFERENCE:-
* https://www.youtube.com/watch?v=1Sy7Wdx_NgA&list=PLYIXQpA4Ir9mJcizhqLt6WjcjOpTQUK0K&index=3&t=60s
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.raghib.selenium.BaseClass;

public class NSEDynamicWebTableExampleUsingSelenium extends BaseClass {
	
	public static void main(String args[]) {
		countRowsandColumns();
		//printAllTableData();
		//printDependingTableData();
	}

	static WebDriver driver;
	static String browserName = "chrome";
	static String browserVersion = "116";
	static String url = "https://www.nseindia.com/market-data/live-equity-market";
	static int totalRows = 0;
	static int totalColumns = 0;

	static By noOfColumns = By.xpath("//table[@id='equityStockTable']/thead/tr/th");
	static By noOfRows = By.xpath("//tr[@class=\" \"]");
	
	static By particularCellValue = By.xpath("//table[@id='equityStockTable']/tbody/tr[3]/td[1]/a");

	public static void getDriverandHitNSEURL() {
		// Chrome Browser
		driver = BaseClass.getDriver(browserName, browserVersion);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);
	}

	public static void countRowsandColumns() {
		getDriverandHitNSEURL();
		
		// Finding number of Rows
		totalRows = driver.findElements(noOfRows).size();
		if (totalRows > 0) {
			System.out.println("No of rows in this table : " + totalRows);
		} else {
			System.out.println("No of rows in this table : " + totalRows);
		}

		// Finding number of Columns
		totalColumns = driver.findElements(noOfColumns).size();
		if (totalColumns > 0) {
			System.out.println("No of columns in this table : " + totalColumns);
		} else {
			System.out.println("No of columns in this table : " + totalColumns);
		}
		BaseClass.quitDriver();
	}
	
	public static void printAllTableData() {
		getDriverandHitNSEURL();
		
		int rows = driver.findElements(noOfRows).size();
		System.out.println("No Of Rows : "+rows);
		int columns = driver.findElements(noOfColumns).size();
		System.out.println("No Of Columns : "+columns);

		// Retrieve all the data of the table - Dynamic Web Table
		System.out.println("All The Data From Table!");
		for (int rowIndex = 1; rowIndex <= rows+1; rowIndex++) {
			for (int colIndex = 1; colIndex <= columns; colIndex++) {
				String allData = driver
						.findElement(
								By.xpath("//table[@id='equityStockTable']/tbody/tr["+rowIndex+"]/td["+colIndex+"]"))
						.getText();
				System.out.print(allData + "     |     ");
			}
			System.out.println();
		}
		BaseClass.quitDriver();
	}
	
	public static void printDependingTableData() {
		getDriverandHitNSEURL();
		
		int rows = driver.findElements(noOfRows).size();
		System.out.println("No Of Rows : "+rows);
		
		// Finding the cell value at specific row and specific column
		WebElement cellAddress = driver.findElement(particularCellValue);
		String value = cellAddress.getText();
		System.out.println("The Cell Value is : " + value);

		// Print Open, High and Low based on value - Dynamic Web Table
		System.out.println("The Open, High and Low of this company " + value + " is ");
		for (int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			String companyName = driver.findElement(By.xpath("//table[@id='equityStockTable']/tbody/tr["+rowIndex+"]/td[1]"))
					.getText();			
			System.out.println("Company Name : "+companyName);
			if (companyName.equalsIgnoreCase(value)) {
				String openData = driver.findElement(By.xpath("//table[@id='equityStockTable']/tbody/tr["+rowIndex+"]/td[2]"))
						.getText();
				String highData = driver
						.findElement(By.xpath("//table[@id='equityStockTable']/tbody/tr["+rowIndex+"]/td[3]")).getText();
				String lowData = driver
						.findElement(By.xpath("//table[@id='equityStockTable']/tbody/tr["+rowIndex+"]/td[4]")).getText();
				System.out.println(openData + " | " + highData + " | " + lowData);
				break;
			}
		}
		BaseClass.quitDriver();
	}
}