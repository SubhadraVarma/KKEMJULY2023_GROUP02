package org.ictakwebsite.pages;



import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorporateMembership {

	
	WebDriver driver;
	
	@FindBy(xpath="//h3[text()=' Corporate Membership Form ']")
	WebElement form;
	
	@FindBy(xpath="//a[contains(text(),' Memberships ')]")
	WebElement Membr;
	
	@FindBy(xpath="//h6[text()= ' Corporate Membership ']")
	WebElement corporate;
	
	@FindBy(xpath="//button[text()='Register Here']")
	WebElement registerco;
	
	@FindBy(css="input[name='name']")
	WebElement Name;
	
	@FindBy(css="input[name='address']")
	 WebElement add;
	
	@FindBy(css="input[name='head']")
	 WebElement head;
	
	@FindBy(css="input[name='nature']")
	WebElement nature;
	
	@FindBy(css="input[name='website']")
	WebElement web;
	
	@FindBy(css="input[name='identityNo']")
	WebElement cin;
	
	@FindBy(css="input[name='GST']")
	WebElement gst_num;
	
	@FindBy(css="input[name='nameofContact']")
	WebElement contactName;
	
	@FindBy(xpath="//label[text()='Mobile Number']//following-sibling::div//child::input")
	WebElement identity;
	
	@FindBy(xpath="//input[@formcontrolname='email']")
	WebElement email;
	
	@FindBy(css="input[name='employeeCount']")
	WebElement count;
	
	@FindBy(css="input[name='details']")
	WebElement det;
	
	@FindBy(xpath="//select[@formcontrolname='typeof']")
	WebElement typeofcompany;
	
	@FindBy(xpath="//span[@class='ng-arrow-wrapper']")
	WebElement collaborate;
	
	@FindBy(xpath="//select[@formcontrolname='patents']")
	WebElement patent;
	
	@FindBy(xpath="//select[@formcontrolname='hire']")
	WebElement hire_fresher;
	
	@FindBy(css="input[id='flexSwitchCheckDefault']")
	WebElement clickchckbox;
	
	@FindBy(xpath="//input[@value='REGISTER']")
	WebElement register;
	
	@FindBy(css="input[name='TechnicalSkill']")
	WebElement techskill;
	
	
	public CorporateMembership(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//click corporate membership dropdown
	public String clickMembership() 
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(Membr));
		Membr.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(corporate));
	    corporate.click();
	    return driver.getCurrentUrl();
	}
	
	//click register here button
	public void registerCorporate()
	{
	    registerco.click();	
	}
	
	
	//scroll down page
	public void scrollpage()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(40,400)");
		
	}
	
	//set the Name
	public boolean setName(String name) 
	{

        
		
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", form);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(Name));
		Name.clear();
		Name.sendKeys(name);
		String namefield=Name.getAttribute("value");
		Pattern ptrn=Pattern.compile("[a-zA-Z][a-zA-Z ]*");  
		Matcher match = ptrn.matcher(namefield); 
		boolean isnamevalid=match.find() && match.group().equals(namefield);;
		return (isnamevalid); 
		
		
	}
	
	//set the address
	public void address(String address)
	{
		
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Name);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		 wait.until(ExpectedConditions.visibilityOf(add));
		 add.clear();
		 add.sendKeys(address);
		
		 
	}
	
	public boolean head_of_the_org(String orghead) 
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", add);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		 wait.until(ExpectedConditions.visibilityOf(head));
		 head.clear();
		 head.sendKeys(orghead);
		 String orgfield=head.getAttribute("value");
	     Pattern ptrn=Pattern.compile("[a-zA-Z][a-zA-Z ]*");  
		 Matcher match = ptrn.matcher(orgfield); 
		 boolean isorgvalid=match.find() && match.group().equals(orgfield);;
		 return (isorgvalid); 
	}
	//"^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$"
	
	public void nature_of_the_org(String naturehead) 
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", head);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(nature));
		nature.clear();
		 nature.sendKeys(naturehead);
		 /*String naturefield=nature.getAttribute("value");
	     Pattern ptrn=Pattern.compile("^[a-zA-Z\\s]*$");  
		 Matcher match = ptrn.matcher(naturefield); 
		 boolean isnaturevalid=match.find() && match.group().equals(naturefield);;
		 return (isnaturevalid); */
	}
	
	public boolean website(String website) 
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nature);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(web));
		web.clear();
		 web.sendKeys(website);
		 String webfield=web.getAttribute("value");
	     Pattern ptrn=Pattern.compile("/(https:\\/\\/www\\.|http:\\/\\/www\\.|https:\\/\\/|http:\\/\\/)?[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})(\\.[a-zA-Z]{2,})?\\/[a-zA-Z0-9]{2,}|((https:\\/\\/www\\.|http:\\/\\/www\\.|https:\\/\\/|http:\\/\\/)?[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})(\\.[a-zA-Z]{2,})?)|(https:\\/\\/www\\.|http:\\/\\/www\\.|https:\\/\\/|http:\\/\\/)?[a-zA-Z0-9]{2,}\\.[a-zA-Z0-9]{2,}\\.[a-zA-Z0-9]{2,}(\\.[a-zA-Z0-9]{2,})?/g");  
	     Matcher match = ptrn.matcher(webfield); 
		 boolean iswebfield=match.find() && match.group().equals(webfield);;
		 return (iswebfield); 
		
	}
	
	
	//set cin
	public void corporateIdentifyNumber(String num) 
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", web);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(cin));
		cin.clear();
		cin.sendKeys(num);

	}
	public void gst(String gst) 
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gst_num);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(gst_num));
		gst_num.clear();
		gst_num.sendKeys(gst);

	}
	
	public boolean name_of_contact(String contact) 
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(contactName));
		contactName.clear();
		contactName.sendKeys(contact);
		String namefield=contactName.getAttribute("value");
		Pattern ptrn=Pattern.compile("[a-zA-Z][a-zA-Z ]*");  
		Matcher match = ptrn.matcher(namefield); 
		boolean isnamevalid=match.find() && match.group().equals(namefield);;
		return (isnamevalid); 

	}
	public boolean phone_num(String inum) 
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", identity);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(identity));
		identity.clear();
		identity.sendKeys(inum);
		String phfield=identity.getAttribute("value");
		Pattern ptrn=Pattern.compile("(0/91)?[7-9][0-9]{9}");  
		Matcher match = ptrn.matcher(phfield); 
		boolean isphnumvalid=match.find() && match.group().equals(phfield);
		return (isphnumvalid); 

	}
	
	public void technical_skill(String skill)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", identity);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(techskill));
		techskill.clear();
		techskill.sendKeys(skill);
	}
	public boolean email(String mail) 
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", email);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(mail);
		String emailfield=email.getAttribute("value");
		Pattern ptrn=Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}");  
		Matcher match = ptrn.matcher(emailfield); 
		boolean isemailvalid=match.find() && match.group().equals(emailfield);;
		return (isemailvalid); 

	}
	public boolean emp_count(String ecount)
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", count);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(count));
		count.clear();
		count.sendKeys(ecount);
		String numfield=count.getAttribute("value");
		Pattern ptrn=Pattern.compile("^[1-9][0-9]*$");  
		Matcher match = ptrn.matcher(numfield); 
		boolean isnumvalid=match.find() && match.group().equals(numfield);;
		return (isnumvalid);

	}
	public void details(String details) 
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", det);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(det));
		det.clear();
		det.sendKeys(details);

	}
	
	
	//set type of the company
	public boolean setTypeOfTheCompany() 
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", typeofcompany);
		Select companytype = new Select(typeofcompany);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(typeofcompany));
		boolean ismultiple=companytype.isMultiple();
		if (ismultiple)
		{
			companytype.selectByIndex(1);
			companytype.selectByValue("Quasi-Govt");
			
		}
		else
		{
			companytype.selectByValue("3: Quasi-Govt");
			
		}
		return ismultiple;
	}
	
	//set collaborate
	public void collaborate(String text )
	{

		//JavascriptExecutor je=(JavascriptExecutor)driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",count);
		
		//WebElement collaborate=driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(collaborate));
		
		collaborate.click();
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", collaborate);
        //
		
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//je.executeScript("arguments[0].click();", collaborate);
		//JavascriptExecutor jse=(JavascriptExecutor)driver;
		//collaborate.click();
		
		WebElement Fresherhiring=driver.findElement(By.xpath("//span[text()='"+text+"']"));
		//WebElement Fresherhiring=driver.findElement(By.xpath("//span[text()='Fresher hiring']"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait1.until(ExpectedConditions.visibilityOf(Fresherhiring));
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", Fresherhiring);
		Fresherhiring.click();
		/*Thread.sleep(1000);
		collaborate.click();
		WebElement empskill=driver.findElement(By.xpath("//span[text()='Employee training in technologysoft skills']"));
		Thread.sleep(1000);
		empskill.click();
		collaborate.click();
		WebElement internships=driver.findElement(By.xpath("//span[text()='Internships']"));
		Thread.sleep(1000);
		internships.click();
		WebElement deselectFresherhiring=driver.findElement(By.xpath("//span[text()='Fresher hiring']//preceding-sibling::span"));
		Thread.sleep(1000);
		deselectFresherhiring.click();
		WebElement deselectempskills=driver.findElement(By.xpath("//span[text()='Employee training in technologysoft skills']//preceding-sibling::span"));
		Thread.sleep(1000);
		deselectempskills.click();*/
		
	}
	
	public boolean no_of_patents() 
	{
		Select patents = new Select(patent);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", patent);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(typeofcompany));
		boolean ismultiple=patents.isMultiple();
		if (ismultiple)
		{
			patents.selectByIndex(3);
			patents.selectByValue("1: 1-10");
			
		}
		else
		{
			patents.selectByValue("1: 1-10");
			
		}
		return ismultiple;
		
	}
	public boolean fresher_hiring() 
	{
		Select hire = new Select(hire_fresher);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hire);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(typeofcompany));
		boolean ismultiple=hire.isMultiple();
		if (ismultiple)
		{
			hire.selectByIndex(3);
			hire.selectByValue("4: 31-40");
			
		}
		else
		{
			hire.selectByValue("2: 11-20");
			//return ismultiple;
		}
		return ismultiple;
	}
	
	
	
	public boolean clickcgeckbox()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickchckbox);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(typeofcompany));
		boolean isselected=clickchckbox.isSelected();
		if(!isselected)
		{
			clickchckbox.click();
			
		}
		
			return isselected;
		
	}
	
	public boolean register() 
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", det);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(typeofcompany));
		boolean isenabled=register.isEnabled();
		if(isenabled) 
		{
		  register.click();
		  Alert alt = driver.switchTo().alert();
		  alt.accept();
		}
		return isenabled;
	}
	
	
	
}
