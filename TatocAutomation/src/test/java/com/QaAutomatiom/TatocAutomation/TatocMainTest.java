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
	
	 @Test
	  public void launchBrowser() {
		tObject.checkColorBox();  
	  }
	 
	 @Test
	 public void CheckBoxColor()
	 {
		 Assert.assertTrue(tObject.checkRepaintBoxWorking());
	 }
	
  @BeforeClass
  public void beforeClass() {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\krk55\\Desktop\\chrome\\chromedriver.exe");
	  driver = new ChromeDriver();
      driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
      tObject = new TatocMain(driver);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
