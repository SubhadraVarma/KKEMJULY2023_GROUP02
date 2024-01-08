package org.ictakwebsite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Pages {
	
	WebDriver driver;
	@FindBy(xpath="//a[contains(text(),' Home ')]")
	WebElement home;
	
	@FindBy(xpath="//a[text()=' About Us ']")
	WebElement aboutUs;
	
	@FindBy(xpath="//a[text()=' Courses ']")
	WebElement courses;
	
	@FindBy(xpath="//button[contains(text(),' Get Started ')]")
	WebElement getStarted;
	
	@FindBy(xpath="//a[text()=' Contact Us ']")
	WebElement contact;
	
	
	public Pages(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	


	public String getHomePage() 
	{
		
		home.click();
		return driver.getCurrentUrl();
	   
	}
	
	public String getAboutUs() 
	{

		aboutUs.click();
		return driver.getCurrentUrl();
	}
	
	public String getCourses()
	{

		
		courses.click();
		return driver.getCurrentUrl();
	}
	
	public String getStarted() 
	{
		getStarted.click();
		return driver.getCurrentUrl();
	}
	
	
	
	
	public String getContactUs() 
	{
        contact.click();
		return driver.getCurrentUrl();
	} 
	
	
	
	
	
	

}
