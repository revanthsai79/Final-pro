package com.capstone1.selenium;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testclass {
	
	public String baseUrl = "http://172.16.33.134";
    String driverPath = "C:\\Users\\Mahesh Samudrala\\Desktop\\StackRoute\\Test automation\\chromedriver.exe";
    public WebDriver driver; 
    public String expected = null;
    public String actual = null;
        @BeforeTest
        public void launchBrowser() 
        {
          System.out.println("launching Chrome browser"); 
          System.setProperty("webdriver.chrome.driver", driverPath);
          driver= new ChromeDriver();
          driver.get(baseUrl);
        }
      
      @Test
      public void verifyHomepageTitle() {
          String expectedTitle = "Akshay Paatra";
          String actualTitle = driver.getTitle();
          Assert.assertEquals(actualTitle, expectedTitle);
      }
          @Test
      public void enter_registered_username_and_password() {
          driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/ul[1]/li[2]/a")).click() ;
          driver.findElement(By.name("uname")).sendKeys("pavanoltraining");
          driver.findElement(By.name("psw")).sendKeys("Test@selenium123");
          driver.findElement(By.xpath("/html/body/form/div[2]/a/button")).click();
      }
          @Test
      public void title(){
          driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/a[3]")).click() ;
          expected = "About us";
          actual = driver.getTitle();
          Assert.assertEquals(actual, expected);
          driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/a[1]")).click() ;
      }
          @Test
      public void checking_the_content(){
        	  driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/a[3]")).click() ;
              actual=driver.findElement(By.name("para")).getText() ;
              expected = "This is the management website of akshaya patra restaurent.";
              Assert.assertEquals(actual, expected);
              driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/a[1]")).click() ;
          }
          @Test
      public void checking_the_contact(){
          	  driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/a[4]")).click() ;
              actual=driver.findElement(By.xpath("/html/body/p[1]")).getText() ;
              expected = "CH. Mani Kumar";
              Assert.assertEquals(actual, expected);
              driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/a[1]")).click() ;
              }
          @Test
      public void checking_the_name(){
              driver.findElement(By.xpath("/html/body/div[4]/a[4]/button")).click() ;
              
              driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/a[1]")).click() ;
                  }
      
      @AfterTest
      public void terminateBrowser(){
          driver.close();
      }

}
