package com.FlipkartAutomation.FlipkartTesting;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppTest 
{
	App appObject;
	
	public AppTest()
	{
		appObject = new App();
	}
	
	@BeforeClass
	public void launchURL() {
		appObject.launchSite();
	}
	
	@Test
	public void loginTest() throws Exception {
		Assert.assertTrue(appObject.loginUser(),"Login Successful");
	}
	
	@Test
	public void productSearched() throws Exception
	{
		appObject.searchProduct();
	}
	
	@AfterClass
	public void closeURL()
	{
		//appObject.closeSite();
	}
	
    }
