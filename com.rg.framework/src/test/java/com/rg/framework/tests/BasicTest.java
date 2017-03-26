package com.rg.framework.tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BasicTest {
	
	@Test
	public void testGrid() throws IOException {
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setPlatform(Platform.VISTA);
		URL url = new URL("http://192.168.1.6:4444/wd/hub");
		

		WebDriver driver = new RemoteWebDriver(url, cap);

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		File file = ((TakesScreenshot ) driver).getScreenshotAs(OutputType.FILE);
		File file2 = new File("C:\\Users\\Rahul\\Desktop\\java\\test.jpg");
		FileUtils.copyFile(file, file2);
		
		driver.close();
		
	}
	

}
