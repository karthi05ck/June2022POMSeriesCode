package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class Links {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		EdgeOptions eo = new EdgeOptions();
		eo.addArguments("--remote-allow-origins=*");
		WebDriver driver = new EdgeDriver(eo);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.co.in");
		By links = By.tagName("a");
		
		Actions act = new Actions(driver);
		List<WebElement> linkList = driver.findElements(links);
		/*for(WebElement e : linkList) {
			if(e.isDisplayed()) System.out.println(e.getText());*/
		for(int i=0; i < linkList.size(); i++) {
			if(linkList.get(i).isDisplayed()) {
				System.out.println("The link name is :" + linkList.get(i).getText());
				act.moveToElement(linkList.get(i)).keyDown(Keys.CONTROL).click().build().perform();
				
			}
			
			
		}
		

	}

}
