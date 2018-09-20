package com.github.adamflorczak.game2048.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTester {


	
	public String getWebPageTittle(String URL) {
		
	//	System.setProperty("webdriver.gecko.driver","C:\\drivers\\Gecko\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get(URL);
		
		return driver.getTitle();
	}
	
	public  String searchSomethingWithBing(String somethingToSearch) throws InterruptedException {
		
	//	System.setProperty("webdriver.gecko.driver","C:\\drivers\\Gecko\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.bing.com");
		
		WebElement element = driver.findElement(By.name("q"));
		
		element.sendKeys(somethingToSearch);
		element.submit();
		
		Thread.sleep(10000L);
		
		System.out.println("Page tittle is : " + driver.getTitle());
		
		return driver.getTitle();
	}
	
}
