package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.FaceBookLoginPage;
import utility.Reports;
@Listeners(test.Listeners.class)
public class FaceBookLoginTest  extends BaseTest{
       
        ExtentReports extentsReport;
        ExtentTest Test;
        
        @BeforeTest
        public void configureReports() {
        	extentsReport= Reports.generateReport();
        }
        
      @BeforeMethod
       public void openBrowser() {
       driver = Browser.OpenChrome("http://www.facebook.com");   
      }
      @Test(priority=1)
	  public void LoginWithValidUserNameAndPassword() {	
    	  Test=extentsReport.createTest("LoginWithValidUserNameAndPassword");
		  FaceBookLoginPage faceBookLoginPage = new FaceBookLoginPage(driver);
		  faceBookLoginPage.enterEmailId("arise@gmail.com");
		  faceBookLoginPage.enterPassword("12345");
		  faceBookLoginPage.clickOnLogin();
	  }
      
 	 @Test(timeOut= 1000,priority=2)
 	  public void LoginWithInvalidUserNameAndValidPass() throws InterruptedException {
 		 
 		 Test=extentsReport.createTest("LoginWithInvalidUserNameAndValidPass");
 		Thread.sleep(3000);
 		 FaceBookLoginPage faceBookLoginPage = new FaceBookLoginPage(driver);
 		  faceBookLoginPage.enterEmailId("a@jbmgmail.com");
 		  faceBookLoginPage.enterPassword("0000");
 		  faceBookLoginPage.clickOnLogin();
 	  }
 	@AfterMethod
	public void addTestStatus(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			
			Test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			
			Test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			
			Test.log(Status.SKIP, result.getName());
		}
 	}		
	
 	 @AfterTest
	     public void publishReports(){
			extentsReport.flush();
	        }
 	 
 //      @Test
//     public void createNewAccountTest()  {
//    	   FaceBookLoginPage faceBookLoginPage = new FaceBookLoginPage(driver);
//    	   faceBookLoginPage.clickOnCreateNewAcc();    	   
//    	   faceBookLoginPage.enterFirstName("Nikita",driver);
//    	   faceBookLoginPage.enterLastName("patil");
//    	   faceBookLoginPage.enterMobileNo("8484982590");
//    	   faceBookLoginPage.enterNewPass("123456");
//    	   faceBookLoginPage.selectBirthDate("26");
//    	   faceBookLoginPage.selectBirthMonth("August");
//    	   faceBookLoginPage.selectBirthYear("2001");
//    	   faceBookLoginPage.selectGender();  	   
//    	   
//       }
       
     
 	

	   
}
