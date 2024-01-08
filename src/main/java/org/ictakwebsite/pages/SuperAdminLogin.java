package org.ictakwebsite.pages;


import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class SuperAdminLogin 
{
	WebDriver driver;
	
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement clklogin;
	
	@FindBy(xpath="//div[@id='exampleModalForm']//h4")
	WebElement getheader1;
	
	@FindBy(xpath="//p[@class='mb-1 text-sm text-white']")
	WebElement getheader2;
	
	@FindBy(xpath="//input[@placeholder='Enter Your Email']")
	WebElement mail;
	
	@FindBy(name="password")
	WebElement upass;
	
	@FindBy(xpath="//form[@role='form text-start']")
	WebElement role;
	
	@FindBy(xpath="//input[@placeholder='Enter Your Email']//following-sibling::small")
	WebElement email_err;
	

	@FindBy(xpath="//input[@name='password']//following-sibling::small")
	WebElement pass_err;
	

	@FindBy(xpath="//button[contains(text(),' Sign in ')]")
	WebElement signin;
	
	@FindBy(xpath="//div[@class='swal2-actions']//child::button[contains(text(),'OK')]")
	WebElement clickOK;
	
	@FindBy(xpath="//a[@aria-controls='ProfileNav']")
	WebElement adminlogout;
	
	@FindBy(xpath="//div[@id='ProfileNav']//child::a")
	WebElement logout;
	
	public SuperAdminLogin(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickLogin()
	{
		clklogin.click();
	}
	
	public String getHeader1() 
	{

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(getheader1));
		String header1=getheader1.getText();
		return header1;
	}
	
	public String getHeader2()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(getheader2));
		String header2=getheader2.getText();
		return header2;
	}
	public void setemail(String email)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(mail));
		mail.clear();
		mail.sendKeys(email);
	}
	public void setPassword(String pass) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(upass));
		upass.clear();
		upass.sendKeys(pass);
	}
	
	public String email_err_msg() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(email_err));
		String err_mail=email_err.getText();
		return err_mail;
	}
	public String password_err_msg() 
	{
		role.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(pass_err));
		
		String err_pass=pass_err.getText();
		return err_pass;
	}
	
	/*public boolean signin()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(signin));
		signin.click();
		Boolean sign=signin.isEnabled();
		return sign;
	}*/
	
	public boolean clicksignin()
	{

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(signin));
		boolean signval=signin.isEnabled();
		if(signin.isEnabled())
		{
			signin.click();
			/*Alert alt = driver.switchTo().alert();
			alt.accept();*/
		 	
		}
		return signval;
	}
	public String warningMsg1()
	{
		String msg1=driver.findElement(By.id("swal2-title")).getText();
		return msg1;
	}
	public String warningMsg2()
	{
		String msg2=driver.findElement(By.id("swal2-html-container")).getText();
		return msg2;
	}
	
	public boolean warning()
	{
		boolean val=clickOK.isDisplayed();
		return val;
	}
	public boolean warning_login() 
	{
		
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(clickOK));
			boolean isDisplay=clickOK.isDisplayed();
			if(isDisplay)
			{
			  clickOK.click();
			}
			return isDisplay;
	}
			
			/* catch (TimeoutException e) {
			//System.out.println("WebDriver couldn’t locate the element");
			return false;
			}*/
		
		
	public void adminlogout() 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(adminlogout));
		//JavascriptExecutor je=(JavascriptExecutor)driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", adminlogout);
		//adminlogout.click();
		
	}
	public void logout() 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(logout));
		logout.click();
	}
}
