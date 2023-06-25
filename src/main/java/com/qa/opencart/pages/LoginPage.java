package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1.private ByLocators
	private By emailId = By.id("input-email");
	private By password = By.xpath("//input[@type='password']");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	
	//2. constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3. page actions/methods
	@Step("......getting the login page title......")
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Login page title is:" + title);
		return title;
	}
	@Step("......getting the login page url......")
	public String getPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Login page url is:" + url);
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		 return eleUtil.waitForElementVisible(forgotPwdLink, AppConstants.DEFAULT_TIME_OUT).isDisplayed();
		
	}
	
	public AccountsPage doLogin(String un, String pwd) {
//		driver.findElement(emailId).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
		System.out.println("App creds are :" + un + ":" + pwd);
		
		eleUtil.waitForElementVisible(emailId, AppConstants.DEFAULT_TIME_OUT).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		
		return new AccountsPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}
	

}
