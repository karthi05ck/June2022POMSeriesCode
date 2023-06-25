package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	private By logoutLink = By.linkText("Logout");
	private By accHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("#search button");
	
	public String getAccPageTitle() {
		String title = driver.getTitle();
		System.out.println("Acc page title is :" + title);
		return title;
	}
	
	public String getAccPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Acc page url is :" + url);
		return url;
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementVisible(logoutLink, AppConstants.DEFAULT_TIME_OUT).isDisplayed();
	}

	public boolean isSearchExist() {
		return eleUtil.waitForElementVisible(search, AppConstants.DEFAULT_TIME_OUT).isDisplayed();
	}
	
	public List<String> getAccPageHeadersList() {
	List<WebElement> accPageHeaderList = driver.findElements(accHeaders);
	List<String> accHeadersValList = new ArrayList<String>();
	for(WebElement e : accPageHeaderList) {
		String value = e.getText();
		accHeadersValList.add(value);
	}
	return accHeadersValList;
		
	}
	
	public SearchPage performSearch(String searchKey) {
		if(isSearchExist()) {
			eleUtil.doSendKeys(search, searchKey);
			eleUtil.doClick(searchIcon);
			return new SearchPage(driver);
			}
		else {
			System.out.println("Not present in page");
			return null;
		}
		
	}
	
	
}
