package org.ictakwebsite.test;

import org.ictakwebsite.classobjects.ClassObjects;
import org.ictakwebsite.constants.AutomationConstants;
import org.ictakwebsite.pages.ContactUsDetails;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestContactUs extends TestBase
{
	
	SoftAssert softassert=new SoftAssert();	
	
	@BeforeClass
	public void setup()
	{
		 ClassObjects.contactus =new ContactUsDetails(driver);
	}
   @Test(priority=0)
    public void validdetails() 
    {
    	Assert.assertEquals(ClassObjects.contactus.phoneNumber(),AutomationConstants.exp_phno);
    	Assert.assertEquals(ClassObjects.contactus.email(),AutomationConstants.exp_email);
    	Assert.assertEquals(ClassObjects.contactus.address(),AutomationConstants.exp_address);
    }
   
   @Test(priority=-1)
    public void invaliddetails()
    {
        ClassObjects.contactus.clickContactUs();
	    ClassObjects.contactus.scrollpage();
	    Assert.assertEquals(ClassObjects.contactus.phoneNumber(),AutomationConstants.exp_phno);
    	Assert.assertEquals(ClassObjects.contactus.email(),AutomationConstants.exp_email);
    	softassert.assertEquals(ClassObjects.contactus.address(),AutomationConstants.wrong_add);
    	softassert.assertAll();
    	//driver.close();
    }
    
   
    
    
    

}
