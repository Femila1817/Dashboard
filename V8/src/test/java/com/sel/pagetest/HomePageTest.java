package com.sel.pagetest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sel.pagerpo.ADGroupPage;
import com.sel.pagerpo.HomePage;
import com.sel.pagerpo.LoginPage;

import TestBase.TestBase;

public class HomePageTest extends TestBase{
	
	LoginPage LPage;
	HomePage HPage;
	ADGroupPage ADGPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		LPage = new LoginPage();
		HPage = LPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=-1)
	public void HomePageTest() {
		String HPtext = HPage.verifyHomePage();
		Assert.assertEquals(HPtext, "Home Page");
	}
	
	@Test(priority=1)
	public void ClickOnAdGroupTab() {
		ADGPage = HPage.LeftPaneAD();
	}

}
