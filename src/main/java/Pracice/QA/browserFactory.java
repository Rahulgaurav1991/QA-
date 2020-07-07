package Pracice.QA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserFactory {
	
	public WebDriver driver=null;
	
	
	
	
	@BeforeTest
	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("");
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
