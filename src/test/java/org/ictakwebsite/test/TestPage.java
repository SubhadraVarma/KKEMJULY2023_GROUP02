package org.ictakwebsite.test;


import org.ictakwebsite.classobjects.ClassObjects;
import org.ictakwebsite.constants.AutomationConstants;
import org.ictakwebsite.pages.CorporateMembership;
import org.ictakwebsite.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPage extends TestBase {
	
	
	@BeforeMethod()
    public void setup()
    {
		ClassObjects.page=new Pages(driver);
    }
    @Test(priority=0)
	public void setHome() 
	{
    	
		String CurrentUrl=ClassObjects.page.getHomePage();
		Assert.assertEquals(CurrentUrl, AutomationConstants.Home_Url);
		System.out.println("CuurentHomeURL is " +CurrentUrl);
		String CurrentStartUrl=ClassObjects.page.getStarted();
		Assert.assertEquals(CurrentStartUrl, AutomationConstants.Courses_Url);
		
		
		
	}
	
	@Test(priority=-1)
	public void aboutUs() 
	{
		
		String CurrentUrl=ClassObjects.page.getAboutUs();
		Assert.assertEquals(CurrentUrl, AutomationConstants.About_Url);
		
	}
	
	@Test(priority=1)
	public void courses() 
	{
		
		String CurrentUrl=ClassObjects.page.getCourses();
		Assert.assertEquals(CurrentUrl, AutomationConstants.Courses_Url);
	}	
	
    @Test(priority=2)
	public void contactUs() 
	{
		
		String CurrentUrl=ClassObjects.page.getContactUs();
		Assert.assertEquals(CurrentUrl, AutomationConstants.ContactUs_Url);
		
	}
	
	
	
	
	

}
