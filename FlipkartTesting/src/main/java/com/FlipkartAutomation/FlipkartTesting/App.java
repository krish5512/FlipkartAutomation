package com.FlipkartAutomation.FlipkartTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
	WebDriver driver;
	String userName;
	boolean condition = false;
	
    public void launchSite() {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\krk55\\Desktop\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
    	driver.get("https://www.flipkart.com/");
    }
    
    public void closeSite() {
    	driver.quit();
    }
    
    public boolean loginUser() throws Exception
    {
    	Thread.sleep(1000);
    	driver.findElement(By.className("_2zrpKA")).sendKeys("k********@xyz.com");
    	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("k**************");
    	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
    	Thread.sleep(1000);
    	userName = driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[1]/div/div/div/div[2]/div[1]/div/div/div/span/div")).getText().toString();
    	if(userName.equals("Krishna"))
    	{
    		System.out.println("Login Successful");
    		condition = true;
    	}
    	return condition;
    }
    
    public void searchProduct() throws Exception
    {
    	driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[1]/div/div/div/div[1]/form/div/div[1]/div/input")).sendKeys("iphone x");
    	driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[1]/div/div/div/div[1]/form/div/div[2]/button")).click();
    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[1]/div[1]")).click();
        for (String winHandle : driver.getWindowHandles()) { 
	           driver.switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)              
	       }
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div[1]/div/div[1]/div[2]/ul/li[2]/form/button")).click();
   	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       }
}
