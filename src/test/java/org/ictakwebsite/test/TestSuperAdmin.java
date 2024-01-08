package org.ictakwebsite.test;

import org.ictakwebsite.classobjects.ClassObjects;
import org.ictakwebsite.constants.AutomationConstants;
import org.ictakwebsite.pages.CorporateMembership;
import org.ictakwebsite.pages.SuperAdminLogin;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSuperAdmin extends TestBase
{
	
	SoftAssert softassert;
	

    @BeforeMethod()
    public void setup()
    {
    	 ClassObjects.admin=new SuperAdminLogin(driver);
    }
	@Test(priority=-1)
	public void getheaders() 
	{
		 
		  ClassObjects.admin.clickLogin();
		  String act_header1=ClassObjects.admin.getHeader1();
		  Assert.assertEquals(act_header1, AutomationConstants.exp_header1);
		  String act_header2=ClassObjects.admin.getHeader2();
		  Assert.assertEquals(act_header2, AutomationConstants.exp_header2);
		 
		
		
	}
	
    @Test(priority=0)
	 public void setDetails() 
	{
		
		ClassObjects.admin.setemail("");
		ClassObjects.admin.setPassword("");
		Assert.assertEquals(ClassObjects.admin.email_err_msg(), AutomationConstants.email_error_msg);
		Assert.assertEquals(ClassObjects.admin.password_err_msg(), AutomationConstants.password_error_msg);
		Assert.assertFalse(ClassObjects.admin.clicksignin(),"Register button is disabled");
				
	}
	 
     @Test(priority=1)
	public void setDetailspositive() 
	{
		
		//ClassObjects.superadmin.clickLogin();
		ClassObjects.admin.setemail("superadmin");
		ClassObjects.admin.setPassword("12345");
		Assert.assertTrue(ClassObjects.admin.clicksignin(),"Register button is disabled");
		ClassObjects.admin.adminlogout();
		ClassObjects.admin.logout();
		
		
	}
	
	@Test(priority=4)
	public void setDetailswrongpass() 
	{
		
		ClassObjects.admin.clickLogin();
		ClassObjects.admin.setemail("superadmin");
		ClassObjects.admin.setPassword("123");
		Assert.assertTrue(ClassObjects.admin.clicksignin(),"Register button is disabled");
		Assert.assertEquals(ClassObjects.admin.warningMsg1(), AutomationConstants.warning_msg1);
		Assert.assertEquals(ClassObjects.admin.warningMsg2(), AutomationConstants.warning_msg2);
		ClassObjects.admin.warning_login();;
		
	}
	
	/*@Test(priority=2)
    public void setDetailsblankpass() 
		{
			
			ClassObjects.admin.clickLogin();
			ClassObjects.admin.setemail("superadmin");
			ClassObjects.admin.setPassword("");
			Assert.assertEquals(ClassObjects.admin.password_err_msg(), AutomationConstants.password_error_msg);
			Assert.assertFalse(ClassObjects.admin.clicksignin(),"Register button is disabled");
			
		}
	
	@Test(priority=3)
    public void setDetailsblankname() 
		{
			
			ClassObjects.admin.clickLogin();
			ClassObjects.admin.setemail("");
			ClassObjects.admin.setPassword("12345");
			Assert.assertEquals(ClassObjects.admin.email_err_msg(), AutomationConstants.email_error_msg);
			Assert.assertFalse(ClassObjects.admin.clicksignin(),"Register button is disabled");
			
		}*/
	}
	
	



