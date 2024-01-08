package org.ictakwebsite.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PartnershipDownload {
	
	WebDriver driver;
	@FindBy(xpath="//span[text()='Partnership']")
	WebElement partnership_click;
	
	@FindBy(xpath="//i[contains(text(),'arrow_downward')]")
	WebElement download;
	
	public PartnershipDownload(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void partnership_click() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(partnership_click));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", partnership_click);
		//corporate_click.click();
	}
	
	public void click_download() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(download));
		download.click();
	}
	

}
