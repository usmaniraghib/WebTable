package com.raghib.selenium.staticwebtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserSelection {

	static WebDriver driver;

	public static WebDriver usingChrome() {
		// Above Selenium Version 4.6+ means 4.9.1
		/*
		 * How To Remove Chrome Warning In Selenium WebDriver- Fix Timed out receiving
		 * message from renderer. java.net.socketexception connection reset
		 */
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		WebDriver driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
