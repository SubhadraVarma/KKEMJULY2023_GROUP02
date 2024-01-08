package org.ictakwebsite.test;


import org.ictakwebsite.classobjects.ClassObjects;
import org.ictakwebsite.constants.AutomationConstants;
import org.ictakwebsite.pages.CorporateMembership;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestMembership extends TestBase
{

    SoftAssert softassert1=new SoftAssert();
    SoftAssert softassert2=new SoftAssert();

    @BeforeMethod()
    public void setup()
    {
    	ClassObjects.corporatemembership=new CorporateMembership(driver);
    }


	@Test(priority=-1)
	public void setHome() 
	{
		
		String CurrentUrl=ClassObjects.corporatemembership.clickMembership();
		Assert.assertEquals(CurrentUrl, AutomationConstants.Corporate_Url);
		ClassObjects.corporatemembership.registerCorporate();
		
	}
    
    @Test(priority=0)
    public void validdetails() 
    {
    	
    	boolean name=ClassObjects.corporatemembership.setName("Subhadra G Varma");
    	Assert.assertTrue(name,"Invalid name");
    	ClassObjects.corporatemembership.address("Vedapuree Gardens");
    	boolean head=ClassObjects.corporatemembership.head_of_the_org("Test");
    	Assert.assertTrue(head,"Invalid Name for head of the organization");
    	//boolean nature=
    	ClassObjects.corporatemembership.nature_of_the_org("Corporate");
    	boolean website=ClassObjects.corporatemembership.website("www.automation.com");
    	Assert.assertTrue(website,"Invalid Name Website");
    	ClassObjects.corporatemembership.setTypeOfTheCompany();
    	ClassObjects.corporatemembership.corporateIdentifyNumber("1234");
    	ClassObjects.corporatemembership.gst("1234");
    	boolean contact_name=ClassObjects.corporatemembership.name_of_contact("Aleena");
    	Assert.assertTrue(contact_name,"Invalid contact name");
    	boolean phnum=ClassObjects.corporatemembership.phone_num("8113068628");
    	Assert.assertTrue(phnum, "Invalid phone number");
    	ClassObjects.corporatemembership.technical_skill("Automation Testing");
    	boolean mail=ClassObjects.corporatemembership.email("Ashlin_123@gmail.com");
    	Assert.assertTrue(mail, "Invalid mail");
    	boolean emp=ClassObjects.corporatemembership.emp_count("234567");
    	Assert.assertTrue(emp, "Invalid count");
    	ClassObjects.corporatemembership.collaborate("Fresher hiring");
    	ClassObjects.corporatemembership.no_of_patents();
    	ClassObjects.corporatemembership.fresher_hiring();
    	ClassObjects.corporatemembership.details("details");
    	boolean selectbox=ClassObjects.corporatemembership.clickcgeckbox();
    	Assert.assertTrue(selectbox,"Not selected");
    	boolean register=ClassObjects.corporatemembership.register();
    	Assert.assertTrue(register,"Register button is disabled");
    	driver.navigate().refresh();
    }
    
   @Test(priority=1)
    public void invalidname() 
    {
	    
    	boolean name=ClassObjects.corporatemembership.setName("Subhadra03");
    	softassert1.assertTrue(name,"Invalid name");
    	ClassObjects.corporatemembership.address("Vedapuree Gardens");
    	boolean head=ClassObjects.corporatemembership.head_of_the_org("Test98$");
    	softassert1.assertTrue(head,"Invalid Name for head of the organization");
    	//boolean nature=
    			ClassObjects.corporatemembership.nature_of_the_org("Corporate");
    	//softassert.assertTrue(nature,"Invalid Name for nature of the organization");
    	boolean website=ClassObjects.corporatemembership.website("test.com");
    	softassert1.assertTrue(website,"Invalid Name for nature of the organization");
    	ClassObjects.corporatemembership.setTypeOfTheCompany();
    	ClassObjects.corporatemembership.corporateIdentifyNumber("1234");
    	ClassObjects.corporatemembership.gst("1234");
    	boolean contact_name=ClassObjects.corporatemembership.name_of_contact("#subha12");
    	softassert1.assertTrue(contact_name,"Invalid contact name");
    	boolean phnum=ClassObjects.corporatemembership.phone_num("08044");
    	softassert1.assertTrue(phnum, "Invalid phone number");
    	ClassObjects.corporatemembership.technical_skill("Automation Testing");
    	boolean mail=ClassObjects.corporatemembership.email("aleena@test.com");
    	softassert1.assertTrue(mail, "Invalid mail");
    	boolean emp=ClassObjects.corporatemembership.emp_count("abcd");
    	softassert1.assertTrue(emp, "Invalid count");
    	ClassObjects.corporatemembership.collaborate("Fresher hiring");
    	ClassObjects.corporatemembership.no_of_patents();
    	ClassObjects.corporatemembership.fresher_hiring();
        ClassObjects.corporatemembership.details("details");
    	boolean selectbox=ClassObjects.corporatemembership.clickcgeckbox();
    	Assert.assertTrue(selectbox,"Not selected");
    	boolean register=ClassObjects.corporatemembership.register();
    	Assert.assertTrue(register,"Register button is disabled");
    	driver.navigate().refresh();
    	softassert1.assertAll();
    }
   @Test(priority=2)
    public void blankdetails()
    {
	   
    	
        boolean name=ClassObjects.corporatemembership.setName("");
        softassert2.assertTrue(name,"Blank Name is Invalid");
	    ClassObjects.corporatemembership.address("");
	    boolean head=ClassObjects.corporatemembership.head_of_the_org("");
	    softassert2.assertTrue(head,"Head of the Organization cannot be blank");
	    //boolean nature=
	    		ClassObjects.corporatemembership.nature_of_the_org("");
	    //softassert.assertTrue(nature,"Nature of the Organization cannot be blank");
 	    boolean website=ClassObjects.corporatemembership.website("");
 	   softassert2.assertTrue(website,"Blank Website is invalid");
	    ClassObjects.corporatemembership.corporateIdentifyNumber("");
	    ClassObjects.corporatemembership.gst("");
	    boolean contact_name=ClassObjects.corporatemembership.name_of_contact("");
	    softassert2.assertTrue(contact_name,"Blank Name Of Contact is Invalid");
	    boolean phnum=ClassObjects.corporatemembership.phone_num("");
	    softassert2.assertTrue(phnum,"Blank Phone Number is Invalid");
	    ClassObjects.corporatemembership.technical_skill("");
	    boolean mail=ClassObjects.corporatemembership.email("");
	    softassert2.assertTrue(mail, "Blank Email is Invalid");
	    boolean emp=ClassObjects.corporatemembership.emp_count("");
	    softassert2.assertTrue(emp, "Blank Employee Count is Invalid");
	    ClassObjects.corporatemembership.no_of_patents();
	    ClassObjects.corporatemembership.details("");
	    boolean selectbox=ClassObjects.corporatemembership.clickcgeckbox();
	    Assert.assertTrue(selectbox,"Not selected");
	    boolean register=ClassObjects.corporatemembership.register();
	    softassert2.assertFalse(register,"Register button is enabled");
	    driver.navigate().refresh();
	    softassert2.assertAll();
}
    
    

}
