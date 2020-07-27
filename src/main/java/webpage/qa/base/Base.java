package webpage.qa.base;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public Base() {
		
	}
	public WebDriver driver;
	
	
	public void initialization() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
        driver.get("https://sdetassessment.azurewebsites.net");
		
	}
	
	public void screenshot() {
		String date = new SimpleDateFormat("yyyy MM dd HH mm ss").format(new Date());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String path = currentDir + "/shots/" + date + ".png";
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		
	
}

