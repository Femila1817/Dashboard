package com.sel.pagerpo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@id='loginSubmitId']")
	WebElement loginSubmitId;
	
	@FindBy(xpath="//img[@id='eyeIcon1']")
	WebElement image;

	public LoginPage() {		
		PageFactory.initElements(driver, this);
	}
	
	public String validatePagetitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginImage() {
		return image.isDisplayed();
			}
	public HomePage Login(String mail, String pwd) {
		email.sendKeys(mail);
		password.sendKeys(pwd);
		loginSubmitId.click();
		loginSubmitId.click();
	return new HomePage();
		
	}
}
