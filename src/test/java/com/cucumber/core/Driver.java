package com.cucumber.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	WebDriver driver;

	public Driver() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static void acessarURL(WebDriver driver, String url) {
		driver.get(url);

	}

	public static void close(WebDriver driver) {
		driver.close();
		driver.quit();
	}
}
