package com.QaAutomatiom.TatocAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TatocMain {

  WebDriver driver;	
  String oldColor, repaintColor;
  Boolean condition= true;
  
  
  
  public TatocMain(WebDriver driver)
  {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\krk55\\Desktop\\chrome\\chromedriver.exe");
	   this.driver= driver;
  }
  public void checkColorBox(){
    driver.findElement(By.className("greenbox")).click();
  }
  public Boolean checkRepaintBoxWorking()
  {
	  
	  WebElement pFrame= driver.findElement(By.id("main"));
	driver.switchTo().frame(pFrame);
	  oldColor = driver.findElement(By.id("answer")).getAttribute("class");
	  while(condition) {
	  driver.switchTo().frame("child");
	  repaintColor = driver.findElement(By.id("answer")).getAttribute("class");
	  driver.switchTo().parentFrame();
	  if(oldColor.equals(repaintColor)) {
		  condition= false;
		  
	  }
	  else {
		  driver.findElement(By.linkText("Repaint Box 2")).click();
		  }
	  }
	  driver.findElement(By.linkText("Proceed")).click();
	  return true;

  }
  
  public Boolean dragTest()
  {
      Actions builder = new Actions(driver);	       
      WebElement from = driver.findElement(By.id("dragbox"));
      WebElement to = driver.findElement(By.id("dropbox"));
      Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
	   dragAndDrop.perform();
	   driver.findElement(By.linkText("Proceed")).click();
	   return true;
  }
  
  public Boolean windowPopTest()
  {
	  String parentHandle = driver.getWindowHandle(); // get the current window handle
      driver.findElement(By.linkText("Launch Popup Window")).click();
      for (String winHandle : driver.getWindowHandles()) { 
          driver.switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)              
      }
      driver.findElement(By.id("name")).sendKeys("Krishna");
      driver.findElement(By.id("submit")).click();	     
      driver.switchTo().window(parentHandle);         // switch back to the original window
	  driver.findElement(By.linkText("Proceed")).click();
	  return true;
  }
public boolean cookieCreateTest() {
	// TODO Auto-generated method stub
	driver.findElement(By.linkText("Generate Token")).click();
    String token = driver.findElement(By.id("token")).getText();
    System.out.println(token);
    String[] splitStr = token.split("\\s+");
    System.out.println(splitStr[1]);
    Cookie name = new Cookie("Token",splitStr[1]);
    driver.manage().addCookie(name);
    driver.findElement(By.linkText("Proceed")).click();	
	return true;
}
}
