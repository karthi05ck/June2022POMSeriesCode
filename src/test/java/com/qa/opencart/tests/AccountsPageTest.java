package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		accPage = lp.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test
	public void accPageTitleTest() {
		String actTitle = accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACC_PAGE_TITLE);
	}
	
	@Test
	public void accPageURLTest() {
		String actURL = accPage.getAccPageURL();
		Assert.assertTrue(actURL.contains("route=account/account"));
	}
	
	@Test
	public void isLogoutLinkExist() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test
	public void accPageHeadersTest() {
	List<String> actualList = accPage.getAccPageHeadersList();
	System.out.println("Acc Page headers Lst");
	Assert.assertEquals(actualList.size(), 4);
	}
	
	@Test
	public void accPageHeadersValueTest() {
		List<String> actualList = accPage.getAccPageHeadersList();
		System.out.println("The actual list is :" + actualList);
		
		Assert.assertEquals(actualList, AppConstants.EXPECTED_ACC_PAGE_HEADER_LIST);
		}
	
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"macbook"},
			{"iMac"},
			{"Apple"},
			{"samsung"}
		};
	}
	@Test(dataProvider = "getProductData")
	public void searchProductCountTest(String searchKey) {
		searchPage = accPage.performSearch(searchKey);
		  Assert.assertTrue(searchPage.getSearchProductsCount()>0);
		
	}
	
	@DataProvider
	public Object[][] getProductTestData() {
		return new Object[][] {
			{"Macbook", "MacBook Pro"},
			{"Macbook", "MacBook Air"},
			{"iMac", "iMac"},
			{"Apple", "Apple Cinema 30\""},
			{"Samsung","Samsung SyncMaster 941BW"},
			
		};
	}
	
	@Test(dataProvider ="getProductTestData")
	public void searchProductTest(String searchKey, String productName) {
		searchPage = accPage.performSearch(searchKey);
		if(searchPage.getSearchProductsCount()>0){
			productInfoPage = searchPage.selectProduct(productName);
			String actProductHeader = productInfoPage.getProductHeaderValue();
			Assert.assertEquals(actProductHeader, productName);
		}
	}
	
	
	
}
