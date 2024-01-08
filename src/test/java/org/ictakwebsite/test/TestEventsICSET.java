package org.ictakwebsite.test;

import org.ictakwebsite.classobjects.ClassObjects;
import org.ictakwebsite.constants.AutomationConstants;
import org.ictakwebsite.pages.EventsICSET;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestEventsICSET extends TestBase{
	
	SoftAssert softassert1=new SoftAssert();
	SoftAssert softassert2=new SoftAssert();
	SoftAssert softassert3=new SoftAssert();
	
	@BeforeMethod
	public void set()
	{
		ClassObjects.events=new EventsICSET(driver);
	}
	
	@Test(priority=-1)
	public void clickEvents() throws InterruptedException
	{
	    
		ClassObjects.events.clickEvents();
		String act_URL=ClassObjects.events.clickICSET();
		Assert.assertEquals(act_URL, AutomationConstants.events_Url);
		System.out.println("Events ICSET URL is "+act_URL);
		 ClassObjects.events.clickApply();
	}
	
	@Test(priority=0)
	public void formheading1()
	{
		
		String act_formheading1	= 
		ClassObjects.events.form_heading1();
		Assert.assertEquals(act_formheading1, AutomationConstants.exp_formheading1);
		System.out.println("Form heading1 is "+act_formheading1);
		
		
	}
	
  @Test(priority=1)
	public void formheading2() throws InterruptedException
	{
		
		String act_formheading2	= ClassObjects.events.form_heading2();
		Assert.assertEquals(act_formheading2, AutomationConstants.exp_formheading2);
		System.out.println("Form heading2 is "+act_formheading2);
	}
	
	@Test(priority=2)
	public void setdetailblank() throws InterruptedException
	{
		
		boolean act_name=ClassObjects.events.setName("");
		softassert1.assertTrue(act_name,"Blank Name is invalid");
		boolean act_email=ClassObjects.events.setEmail("");
		softassert1.assertTrue(act_email,"Blank Email is invalid");
		boolean act_num=ClassObjects.events.setNumber("");
		softassert1.assertTrue(act_num,"Blank Number is invalid"); 
		ClassObjects.events.clickregister();
		softassert1.assertAll();

		
	}
	@Test(priority=5)
	public void setdetailsvalid() throws InterruptedException
	{
		
		 ClassObjects.events.clickApply();
		 boolean act_name=ClassObjects.events.setName("Ashlin George");
		 Assert.assertTrue(act_name,"Blank Name is invalid");
		 boolean act_email=ClassObjects.events.setEmail("Ashlin_123@gmail.com");
		 Assert.assertTrue(act_email,"Blank Email is invalid");
		 boolean act_num=ClassObjects.events.setNumber("8345672190"); 
		 Assert.assertTrue(act_num,"Blank Number is invalid");
		 ClassObjects.events.clickregister();
		
		
	}
   @Test(priority=3)
	public void setdetailsinvalid_testcase_1() 
	{
		
    	boolean act_name=ClassObjects.events.setName("Ash9lin");
    	softassert2.assertTrue(act_name,"Numbers are not allowed in Name field");
		 boolean act_email=ClassObjects.events.setEmail("Ashlin123#test");
		 softassert2.assertTrue(act_email,"Invalid email"); 
		 boolean act_num=ClassObjects.events.setNumber("83456721900123");
		 softassert2.assertTrue(act_num,"Number greater than 10 is invalid");  
		 softassert2.assertFalse(ClassObjects.events.clickregister(),"Register button is enabled");
		 softassert2.assertAll();
	
	}
    
   @Test(priority=4)
    public void setdetailsinvalid_testcase_2()
    {
    	 
    	 ClassObjects.events.clickApply();
 		 boolean act_name=ClassObjects.events.setName("@Ashlin");
 		 softassert3.assertTrue(act_name,"Special characters are not allowed in Name field");
 		 boolean act_email=ClassObjects.events.setEmail("Ashlin123gmail");
 		softassert3.assertTrue(act_email,"@ should be present between domain name and username"); 
 		 boolean act_num=ClassObjects.events.setNumber("834567219");
 		softassert3.assertTrue(act_num,"Number less than 10 is invalid");  
 		softassert3.assertFalse(ClassObjects.events.clickregister(),"Register button is enabled");
 		softassert3.assertAll();
    }
		
	
	
	
	

}
