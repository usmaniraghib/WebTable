package com.raghib.selenium.staticwebtable;

//NOTE :- Try to type one import statement then only import reference will be provided by eclipse.

/*
* REFERENCE:-
* https://www.youtube.com/playlist?list=PLYIXQpA4Ir9mJcizhqLt6WjcjOpTQUK0K
*/

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaticWebTableExampleUsingTestng {

	WebDriver driver;
	
	By noOfColumns = By.xpath("/html/body/table/tbody/tr/th");
	By noOfRows = By.xpath("/html/body/table/tbody/tr/td[1]");

	By particularCellValue = By.xpath("/html/body/table/tbody/tr[5]/td[1]");

	By priceColumn = By.xpath("/html/body/table/tbody/tr/td[4]");

	@BeforeMethod
	public void openBrowser() {
		driver = BrowserSelection.usingChrome();
	}

	@Test
	public void tableDetails() throws InterruptedException, AWTException {
		
		driver.get(System.getProperty("user.dir") + "\\Table\\StaticWebTable.html");
		// Modify Wait time as per the Network Ability.
		// From Selenium 4 onwards implicitWait and WebDriverWait(Explicit wait) for
		// long is deprecated.
		// So we can handle WebDriverWait in Selenium like below
		Duration duration = Duration.ofSeconds(30);
		driver.manage().timeouts().implicitlyWait(duration);
		driver.manage().timeouts().pageLoadTimeout(duration);

		// Finding number of Columns
		List<WebElement> totalColumns = driver.findElements(noOfColumns);
		int columnCount = 0;
		for (int i = 0; i < totalColumns.size(); i++) {
			columnCount++;
		}
		if (columnCount > 0) {
			System.out.println("No of columns in this table : " + columnCount);
		} else {
			System.out.println("No of columns in this table : " + columnCount);
		}

		// Finding number of Rows
		List<WebElement> totalRows = driver.findElements(noOfRows);
		int rowCount = 0;
		for (int i = 0; i < totalRows.size(); i++) {
			rowCount++;
		}
		if (rowCount > 0) {
			System.out.println("No of rows in this table : " + rowCount);
		} else {
			System.out.println("No of rows in this table : " + rowCount);
		}

		// Finding the cell value at 4th row and 1st column
		WebElement cellAddress = driver.findElement(particularCellValue);
		String value = cellAddress.getText();
		System.out.println("The Cell Value is : " + value);

		List<WebElement> priceColumns = driver.findElements(priceColumn);
		int sum_price = 0;
		for (WebElement pc : priceColumns) {
			sum_price = sum_price + Integer.parseInt(pc.getText());
		}
		System.out.println("Total Price: " + sum_price);

		driver.quit();
	}
}
