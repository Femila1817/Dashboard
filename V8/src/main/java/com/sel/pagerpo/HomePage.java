package com.sel.pagerpo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//p[contains(text(),'Manage')]")
	WebElement Manage;
	
	@FindBy(xpath="//span[contains(text(),'Advance Group')]")
	WebElement LfADGrp;
	
	@FindBy(xpath="//span[@id='pageName']")
	WebElement HomePageText;
	
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePage() {
		return HomePageText.getText();
		
	}
	
	public ADGroupPage LeftPaneAD() {
		Actions action = new Actions(driver);
		action.click(Manage).build().perform();
		LfADGrp = wait.until(ExpectedConditions.elementToBeClickable(LfADGrp));
		
		LfADGrp.click();
		
		
		return new ADGroupPage();
		
	}
	

}
