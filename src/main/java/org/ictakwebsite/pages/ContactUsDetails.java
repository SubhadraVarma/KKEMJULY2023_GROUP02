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

import dev.failsafe.internal.util.Assert;

public class ContactUsDetails {
	
	@FindBy(xpath="//a[text()=' Contact Us ']")
	WebElement contact;
	
	@FindBy(xpath="//i[@class='fas fa-phone text-sm']//following::span[1]")
	WebElement num;
	
	@FindBy(xpath="//i[@class='fas fa-phone text-sm']//following::span[2]")
	WebElement email;
	
	@FindBy(xpath="//i[@class='fas fa-phone text-sm']//following::span[3]")
	WebElement address;
	
	WebDriver driver;
	public ContactUsDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Navigate to Contact Us Page
	public void clickContactUs() 
	{
	    contact.click();
	}
	
	public void scrollpage()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(40,400)");
		
	}
	
	public String phoneNumber() 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(num));
		String number=num.getText();
		return number;
	}
	public String email() 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(email));
		String mail=email.getText();
		return mail;
	}
	public String address() 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(address));
		String add=address.getText();
		return add;
	}
	
	

}
