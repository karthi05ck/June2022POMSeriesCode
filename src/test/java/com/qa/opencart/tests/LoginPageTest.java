package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC-100: design login for open cart test app" )
@Story("User login: features")

public class LoginPageTest extends BaseTest {
	@Severity(SeverityLevel.TRIVIAL)
	@Description("getting title of the page ---- tester - k ")
	@Test(priority =1)
	public void getTitltePageTest() {
		String actTitle = lp.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
		
	}
	
	@Severity(SeverityLevel.BLOCKER)
	@Description("checking forgot pwd link ---- tester - k ")
	@Test(priority =2)
	public void isLinkDisplayedTest() {
		Assert.assertTrue(lp.isForgotPwdLinkExist());
	}
	@Test(priority =3)
	public void loginPageURLTest() {
		String actURL = lp.getPageUrl();
		Assert.assertTrue (actURL.contains("route=account/login"));
	}
 
	@Severity(SeverityLevel.BLOCKER)
	@Description("checking login of the page ---- tester - k ")
	@Test(priority =4)
	public void loginTest() {
		accPage = lp.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
}
