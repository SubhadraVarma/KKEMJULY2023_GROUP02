package org.ictakwebsite.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.ictakwebsite.classobjects.ClassObjects;
import org.ictakwebsite.pages.CorporateMembershipDownload;
import org.ictakwebsite.pages.SuperAdminLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCorporateMembershipDownload extends TestBase{
	
	
	
	final String expectedFinalName="ExcelSheet.xlsx";
	
	@BeforeTest
	public void cleanFolder() throws IOException
	{
		File directory=new File(downloadLocation);
		FileUtils.cleanDirectory(directory);
		
	}
	
    @Test
	public void downloadTest() throws InterruptedException
	{
		
		ClassObjects.admin=new SuperAdminLogin(driver);
		ClassObjects.admin.clickLogin();
		ClassObjects.admin.setemail("superadmin");
		ClassObjects.admin.setPassword("12345");
		ClassObjects.admin.clicksignin();
    	ClassObjects.corpmembershipdownload=new CorporateMembershipDownload(driver);
		ClassObjects.corpmembershipdownload.corporate_membership_click();
		ClassObjects.corpmembershipdownload.click_download();
		Thread.sleep(1000);
		Assert.assertTrue(verifyDownloadedFile(),"Downloaded document is found");
		ClassObjects.admin.adminlogout();
		ClassObjects.admin.logout();
		//driver.close();
		
	}

	public boolean verifyDownloadedFile() {
		// TODO Auto-generated method stub
		File folder=new File(downloadLocation); 
		File[] listOfFiles=folder.listFiles();
		boolean isFileAvailable=false;
		for(File listOfFile:listOfFiles)
		{
			if(listOfFile.isFile())
			{
				String fileName=listOfFile.getName();
				System.out.println("File  "+fileName);
				if(fileName.matches(expectedFinalName))
				{
					isFileAvailable=true;
				}
			}
		}
		
		return isFileAvailable;
	}

	 // @Test
	  public void downloadFirefoxTest()
	  {
		  FirefoxOptions options=new FirefoxOptions();
		  options.addPreference("browser.download.folderList",2);
		  options.addPreference("browser.download.dir",downloadLocation);
		  options.addPreference("browser.download.userDownloadDir",true);
		  options.addPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf;text/plain;application/text;text/xml;application/xml");
		  options.addPreference("pdfjs.disabled",true);
		  WebDriver driver=new FirefoxDriver(options);
		  driver.manage().window().maximize();
		  driver.get("http://64.227.132.109/LandingPage");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			ClassObjects.admin=new SuperAdminLogin(driver);
			ClassObjects.admin.clickLogin();
			ClassObjects.admin.setemail("superadmin");
			ClassObjects.admin.setPassword("12345");
		    ClassObjects.admin.clicksignin();
	    	ClassObjects.corpmembershipdownload=new CorporateMembershipDownload(driver);
			ClassObjects.corpmembershipdownload.corporate_membership_click();
			ClassObjects.corpmembershipdownload.click_download();
			Assert.assertTrue(verifyDownloadedFile(),"Downloaded document is found");
			ClassObjects.admin.adminlogout();
			ClassObjects.admin.logout();
	  }
}
