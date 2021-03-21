package com.cucumber.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.enums.ByValue;

public class Element {
	private WebDriver driver;
	private String value;
	private ByValue byValue;

	public Element(WebDriver driver, ByValue byValue, String value) {
		super();
		this.driver = driver;
		this.value = value;
		this.byValue = byValue;
	}

	public WebElement criarElemento() {
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			switch (byValue) {
			case XPATH:
				return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
			case ID:
				return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
			case CLASS_NAME:
				return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(value)));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void click() {
		criarElemento().click();
	}

	public void sendKeys(String string) {
		criarElemento().sendKeys(string);
	}
}
