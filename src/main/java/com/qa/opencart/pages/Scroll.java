package com.qa.opencart.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class Scroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		

		EdgeOptions eo = new EdgeOptions();
		eo.addArguments("--remote-allow-origins=*");
		WebDriver driver = new EdgeDriver(eo);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.geeksforgeeks.org/how-to-scroll-down-to-bottom-of-page-in-selenium-using-javascriptexecutor/");
		Thread.sleep(5000);
System.out.println("Page is loaded");
		Actions act = new Actions(driver);
		//act.KeyDown(Keys.CONTROL).sendKeys(Keys.END);
		act.click().keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		Thread.sleep(5000);
		

	}

}
