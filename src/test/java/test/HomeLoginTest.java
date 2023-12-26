package test;

import org.testng.annotations.BeforeMethod;

import pojo.Browser;

public class HomeLoginTest extends BaseTest {
        @BeforeMethod
        public void openChrome() {
        driver = Browser.OpenChrome("https://facebook.com");
        
        }
}
