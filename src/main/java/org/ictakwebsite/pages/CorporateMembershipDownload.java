package org.ictakwebsite.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorporateMembershipDownload {
	
	WebDriver driver;
	@FindBy(xpath="//span[text()='Corporate Membership']")
	WebElement corporate_click;
	
	@FindBy(xpath="//i[contains(text(),'arrow_downward')]")
	WebElement download;
	
	public CorporateMembershipDownload(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void corporate_membership_click() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(corporate_click));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", corporate_click);
		//corporate_click.click();
	}
	
	public void click_download() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(download));
		download.click();
	}
	

}
