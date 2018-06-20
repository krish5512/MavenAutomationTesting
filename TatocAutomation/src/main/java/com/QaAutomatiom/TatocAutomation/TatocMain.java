package com.QaAutomatiom.TatocAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
	  driver.switchTo().frame("main");
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
}
