package org.ictakwebsite.pages;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.UnexpectedAlertBehaviour;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventsICSET {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),' Events ')]")
	WebElement clickEvents;
	
	@FindBy(xpath="//h6[contains(text(),'ICSET')]")
	WebElement clickICSET;
	
	@FindBy(xpath="//button[contains(text(),'Apply Now')]")
	WebElement Apply;
	
	@FindBy(xpath="//div[@id='exampleModalSignup']//h4")
	WebElement formh1;
	
    @FindBy(xpath="//div[@id='exampleModalSignup']//p")
	WebElement formh2;
	
	@FindBy(name="name")
	WebElement name;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement email;
	
	@FindBy(name="phoneno")
	WebElement phnum;
	
	@FindBy(xpath="//button[contains(text(),'Register')]")
	WebElement register;
	
	
	
	
	public EventsICSET(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickEvents()
	{
	
		clickEvents.click();
		
	}
	
	public String clickICSET() 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(clickICSET));
		clickICSET.click();
		return driver.getCurrentUrl();
	}
	
	public void clickApply() 
	{
		
		Apply.click();
		
	}
	
	public String form_heading1()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		String heading1=wait.until(ExpectedConditions.visibilityOf(formh1)).getText();
		 return heading1;
		
	}
	public String form_heading2() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		String heading2=wait.until(ExpectedConditions.visibilityOf(formh2)).getText();
		return heading2;
	}
	public boolean setName(String uname)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(name));
		name.clear();
		name.sendKeys(uname);
		String namefield=name.getAttribute("value");
		Pattern ptrn=Pattern.compile("[a-zA-Z][a-zA-Z ]*");//regular
				 
		Matcher match = ptrn.matcher(namefield); 
		boolean isnamevalid=match.find() && match.group().equals(namefield);;
		return (isnamevalid); 
	}
	public boolean setEmail(String mail) 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(mail);
		String emailfield=email.getAttribute("value");
		Pattern ptrn=Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}");  
		Matcher match = ptrn.matcher(emailfield); 
		boolean isemailvalid=match.find() && match.group().equals(emailfield);;
		return (isemailvalid); 
	}
	public boolean setNumber(String num) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(phnum));
		phnum.clear();
		phnum.sendKeys(num);
		String phfield=phnum.getAttribute("value");
		Pattern ptrn=Pattern.compile("(0/91)?[7-9][0-9]{9}");  
		Matcher match = ptrn.matcher(phfield); 
		boolean isphnumvalid=match.find() && match.group().equals(phfield);
		return (isphnumvalid);  
		
	}
	/*public boolean register()
	{
		boolean reg=register.isEnabled();
		return reg;
	}*/
	public boolean clickregister()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(register));
		boolean isreg=register.isEnabled();
		if(isreg==true)
		{
			register.click();
			Alert alt = driver.switchTo().alert();
			alt.accept();
			
		}
		//System.out.println(isreg);
		return isreg;
	}

}
