package com.sel.pagetest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sel.pagerpo.LoginPage;

import TestBase.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage lPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		lPage = new LoginPage();
	}
	
	@Test
	public void loginPageTitletest() {
		String title = lPage.validatePagetitle();
		Assert.assertEquals(title, "Dashboard :: Login");
	}
	
	@Test
	public void loginImgae() {
		boolean flag = lPage.validateLoginImage();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void loginTest() {
		lPage.Login("femila@nanoheal.com", "nanoheal@123");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
