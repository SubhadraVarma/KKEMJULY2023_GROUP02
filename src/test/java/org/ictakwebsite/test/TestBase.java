package org.ictakwebsite.test;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop=null;
	final static String downloadLocation="C:\\Users\\USER\\Downloads";
	
	@BeforeTest
	public void setUp() throws IOException
	{
		
		prop=new Properties();
		FileInputStream ip=new FileInputStream("D:\\Software_Testing\\Project\\ICTAKWebsite\\src\\test\\resources\\config.properties");
		prop.load(ip);
		String newBrowser=prop.getProperty("browser");
		if(newBrowser.equalsIgnoreCase("Chrome"))
		{
			//driver=new ChromeDriver();
			ChromeOptions options=new ChromeOptions();
			Map<String,Object>prefs=new HashMap<>();
			prefs.put("download.default_directory", downloadLocation);
			options.setExperimentalOption("prefs", prefs);
			driver=new ChromeDriver(options);
		}
		else if(newBrowser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
	}
	
	/*@AfterTest
	public void closebrowser()
	{
		driver.close();
	}*/
	
	
}