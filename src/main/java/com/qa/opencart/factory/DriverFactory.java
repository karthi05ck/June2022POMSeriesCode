package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	
	public static String highlight;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * 
	 * @param browserName
	 * @return this method returns driver instance
	 */
	public WebDriver initDriver (Properties prop) {
		optionsManager = new OptionsManager(prop);
		
		highlight = prop.getProperty("highlight").trim();
		String browserName = prop.getProperty("browser");
		
		if(browserName.trim().equalsIgnoreCase("chrome")){
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--remote-allow-origins=*");
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if(browserName.trim().equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please pass right browser:"  + browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	/*
	 * get the local thread copy of driver
	 */
	public synchronized static WebDriver getDriver() {
		return tlDriver.get(); 
	}
	
	/**
	 * @return 
	 * this method is reading properties from .properties file
	 */
	public Properties initProp() {
		
		//mvn clean install -Denv="qa"
		//mvn clean install
		
		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");
		System.out.println("Running testcases on Env::" + envName);
		
		try {
		if(envName == null) {
			System.out.println("No env is passed..Running tests on QA env..");
			 ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
		}
		
		else {
			switch(envName.toLowerCase().trim()) {
			case "qa":
				 ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
			case "prod":
				 ip = new FileInputStream("./src/test/resources/config/config.properties");
				break;
			default:
				System.out.println("wrong env is passed:: No need to run testcases...." + envName);
				break;
			
			}
		}
		} catch (FileNotFoundException e) {
			
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
//		try {
//			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return prop;
	}
	
	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtil.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
