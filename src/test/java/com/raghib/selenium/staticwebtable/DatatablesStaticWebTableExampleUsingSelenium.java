package com.raghib.selenium.staticwebtable;

//NOTE :- Try to type one import statement then only import reference will be provided by eclipse.

/*
* REFERENCE:-
* https://www.youtube.com/watch?v=1Sy7Wdx_NgA&list=PLYIXQpA4Ir9mJcizhqLt6WjcjOpTQUK0K&index=3&t=60s
*/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.raghib.selenium.BaseClass;

public class DatatablesStaticWebTableExampleUsingSelenium extends BaseClass {

	static WebDriver driver;
	
	static String browserName = "chrome";
	static String browserVersion = "116";
	static String url = "https://datatables.net/examples/basic_init/scroll_y.html";

	static By noOfColumns = By.xpath("//*[@id=\"example\"]//thead/tr/th");
	static By noOfRows = By.xpath("//*[@id=\"example\"]/tbody/tr");

	static By particularCellValue = By.xpath("//table[@id=\"example\"]/tbody/tr[20]/td[1]");

	public static void main(String args[]) {
		// Chrome Browser
		driver = BaseClass.getDriver(browserName, browserVersion);
		// Modify Wait time as per the Network Ability.
		// From Selenium 4 onwards implicitWait and WebDriverWait(Explicit wait) for
		// long is deprecated.
		// So we can handle WebDriverWait in Selenium like below
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);

		// Finding number of Rows
		int totalRows = driver.findElements(noOfRows).size();
		if (totalRows > 0) {
			System.out.println("No of rows in this table : " + totalRows);
		} else {
			System.out.println("No of rows in this table : " + totalRows);
		}

		// Finding number of Columns
		int totalColumns = driver.findElements(noOfColumns).size();
		if (totalColumns > 0) {
			System.out.println("No of columns in this table : " + totalColumns);
		} else {
			System.out.println("No of columns in this table : " + totalColumns);
		}

		// Finding the cell value at specific row and specific column
		WebElement cellAddress = driver.findElement(particularCellValue);
		String value = cellAddress.getText();
		System.out.println("The Cell Value is : " + value);

		// Retrieve all the data of the table - Dynamic Web Table
		System.out.println("All The Data From Table!");
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			for (int colIndex = 1; colIndex <= totalColumns; colIndex++) {
				String allData = driver
						.findElement(
								By.xpath("//table[@id=\"example\"]/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]"))
						.getText();
				System.out.print(allData + "     |     ");
			}
			System.out.println();
		}

		// Print Age and Salary of Gavin Joyce name - Dynamic Web Table
		System.out.println("Print Age and Salary of Gavin Joyce.");
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			String nameData = driver.findElement(By.xpath("//table[@id=\"example\"]/tbody/tr[" + rowIndex + "]/td[1]"))
					.getText();
			if (nameData.equalsIgnoreCase("Gavin Joyce")) {
				String ageData = driver
						.findElement(By.xpath("//table[@id=\"example\"]/tbody/tr[" + rowIndex + "]/td[4]")).getText();
				String salaryData = driver
						.findElement(By.xpath("//table[@id=\"example\"]/tbody/tr[" + rowIndex + "]/td[6]")).getText();
				System.out.println(nameData + " | " + ageData + " | "+ salaryData);
			}			
		}
		//BaseClass.quitDriver();
	}
}