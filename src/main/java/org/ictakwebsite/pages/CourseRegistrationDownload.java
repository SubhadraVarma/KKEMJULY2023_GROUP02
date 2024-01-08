package org.ictakwebsite.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseRegistrationDownload {
	
	WebDriver driver;
	@FindBy(xpath="//span[text()='Course Registration']")
	WebElement courses_click;
	
	@FindBy(xpath="//i[contains(text(),'arrow_downward')]")
	WebElement download;
	
	public CourseRegistrationDownload(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void course_reg_click() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(courses_click));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", courses_click);
		//corporate_click.click();
	}
	
	public void click_download() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(download));
		download.click();
	}
	

}
