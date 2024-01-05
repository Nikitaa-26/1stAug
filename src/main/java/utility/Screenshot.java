package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
  public static void clicKScreenshot(WebDriver driver, String name) throws IOException {
	File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    File destination = new File("D:\\IDE\\FaceBook\\Screenshots"+name+".png");
    FileHandler.copy(Source, destination);
  }
}
