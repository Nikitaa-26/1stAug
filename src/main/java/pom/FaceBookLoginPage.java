package pom;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBookLoginPage {
	@FindBy(xpath="//input[@id='email']") private WebElement email;
	@FindBy(xpath="//input[@type='password']") private WebElement pass ;
	@FindBy(xpath="//button[@name='login']") private WebElement logIn;
	@FindBy(xpath="//a[text()='Forgotten password?']") private WebElement forgotPass;
	@FindBy(xpath="//a[@data-testid='open-registration-form-button']") private WebElement createNewAcc ;
    @FindBy(xpath="//a[text()='Create a Page']") private WebElement createApage;
	//  Create New Acc
	@FindBy(xpath="//input[@name='firstname']") private WebElement firstName;
	@FindBy(xpath="//input[@name='lastname']") private WebElement lastName;
	@FindBy(xpath="//input[@aria-label='Mobile number or email address']") private WebElement mobileNo ;
	@FindBy(xpath="//input[@autocomplete='new-password']") private WebElement newpass ;
	@FindBy(xpath="//select[@title='Day']") private WebElement birthDate ;
	@FindBy(xpath="//select[@aria-label='Month']") private WebElement Month;
	@FindBy(xpath="//select[@aria-label='Year']") private WebElement Year;
	@FindBy(xpath="//label[text()='Female']") private WebElement Gender;
	
//	@FindBy(xpath="//button[text()='Sign Up']") private WebElement signUp;
	
	
	public FaceBookLoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	public void enterEmailId(String mailId) {
		email.sendKeys(mailId);
	}
	public void enterPassword(String password) {
		pass.sendKeys(password);
	}
	public void clickOnLogin() {
		logIn.click();
	}
	public void clickOnForgotPass() {
		forgotPass.click();
	}
	public void clickOnCreateNewAcc() {
		createNewAcc.click();
	}	
	public void clickOnCreateApage() {
		createApage.click();
	}
	//Create New Acc
	public void enterFirstName(String firstname,WebDriver driver) {
	  //explicit wait
	  WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.visibilityOf(firstName));
		//fluent wait
//		FluentWait<WebDriver> wait = new FluentWait(driver);
//		wait.withTimeout(Duration.ofMillis(5000));
//		wait.pollingEvery(Duration.ofMillis(100));
//		wait.ignoring(NoSuchElementException.class);
//		wait.until(ExpectedConditions.visibilityOf(firstName));
	  firstName.sendKeys(firstname);
	}
	public void enterLastName(String lastname) {
		lastName.sendKeys(lastname);
	}
	public void enterMobileNo(String mobileno) {
		mobileNo.sendKeys(mobileno);
	}
	public void enterNewPass(String newPass) {
		newpass.sendKeys(newPass);
	}
	public void selectBirthDate(String date) {
	  	birthDate.click();
	  	Select D = new Select(birthDate);
	  	D.selectByVisibleText("26");
	}
	public void selectBirthMonth(String month) {
		Month.click();
		Select m = new Select(Month);
		m.selectByIndex(7);
	}
	public void selectBirthYear(String year) {
		Year.click();
		Select y = new Select(Year);
		y.selectByValue("2001");
	}
	public void selectGender() {
		Gender.click();
	}
	
//	public void clickOnsignUp() {
//		signUp.click();
//	}
	
	
	
}
