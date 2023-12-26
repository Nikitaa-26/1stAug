package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	public static WebDriver OpenChrome(String url) {
	System.setProperty("webdriver.chrome.driver","D:\\\\ARISE CLASS\\\\Selenium Downloaded Files\\\\chromedriver-win64\\\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
	driver.get(url);
    driver.manage().window().maximize();
     //   implicit wait
    //   driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    return driver;
	}
}