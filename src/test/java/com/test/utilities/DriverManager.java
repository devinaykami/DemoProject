package com.test.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static WebDriver driver;

	protected static String browser;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void initializeDriver() {

		browser = System.getProperty("browser");

		if (browser == null) {

			browser = "chrome";
		}

		if (driver == null) {

			if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().driverVersion("126.0.6478.127").setup();

				// WebDriverManager.chromedriver().setup();

				// Initialize the WebDriver
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("firefox")) {

				WebDriverManager.firefoxdriver().setup();

				// WebDriverManager.chromedriver().setup();

				// Initialize the WebDriver
				driver = new FirefoxDriver();

			}

			else if (browser.equalsIgnoreCase("safari")) {

				WebDriverManager.safaridriver().setup();

				driver = new SafariDriver();
			}

			// Maximize the browser window
			driver.manage().window().maximize();

			// Set implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Navigate to the base URL
			driver.get("https://demo.guru99.com/");
		}
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
