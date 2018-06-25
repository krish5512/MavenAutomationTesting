package com.QaAutomatiom.TatocAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TatocMainTest {
	
	WebDriver driver;
	
	
	TatocMain tObject;
	
	 @Test(priority= 0)
	  public void launchBrowser() {
		tObject.checkColorBox();  
	  }
	 
	 @Test(priority= 1)
	 public void CheckBoxColor()
	 {
		 Assert.assertTrue(tObject.checkRepaintBoxWorking());
	 }
	
	 @Test (priority = 2)
     public void dragDropTest()
     {
		 Assert.assertTrue(tObject.dragTest());
     }
	 
	 
	 @Test (priority = 3)
	 public void windowPopUpTest()
	 {
		 Assert.assertTrue(tObject.windowPopTest());
	 }
	 
	 @Test (priority = 4)
	 public void cookieTest() {
		 Assert.assertTrue(tObject.cookieCreateTest());
	 }	 
	 
	 @BeforeClass
  public void beforeClass() {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\prkrishnakumar\\eclipse-workspace\\chromedriver.exe");
	  driver = new ChromeDriver();
      driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
      tObject = new TatocMain(driver);
  }

  @AfterClass
  public void afterClass() {
	 driver.quit();
  }

}
