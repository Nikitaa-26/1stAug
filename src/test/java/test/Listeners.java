package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.Screenshot;

public class Listeners extends BaseTest implements ITestListener{
	WebDriver driver;
   public void onTestStart(ITestResult result) {
	   System.out.println("Test Started :"+ result.getName());
   }
   public void onTestSuccess(ITestResult result) {
	   System.out.println("Test Success :"+ result.getName());
	  
   }
   public void onTestFailure(ITestResult result) {
	   System.out.println("Test Failure :"+ result.getName());
	   try {
			Screenshot.clicKScreenshot(driver, result.getName());
		    } 
		   catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	   
   }
   public void onTestSkipped(ITestResult result) {
	   System.out.println("Test Skipped :"+ result.getName());
   }
}
