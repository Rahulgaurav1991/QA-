package qa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Torrent {
	
	public WebDriver driver;
	public String text="";
	
	@BeforeTest(enabled = false)
	public void LaunchSuite() {
		
		
		WebDriverManager.chromedriver().avoidAutoVersion().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--silent");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://torrentcounter.red/");
		driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
		
	}
	
	
	
	@Test(enabled = false)
	public void torrenttest() {
		
	 List<WebElement> allTop = driver.findElements(By.xpath("//h3[.='Top Genre']/..//p"));
	 for(WebElement name:allTop) {
		 text=name.getText();
		 System.out.println("the value form text  box is --->"+text);
		 if(text.contains("Drama")) {
			 name.click();
			 break;
			 
		 }
		
	 }
	}
	@Test
	public void flipkatTest() {
		int a[]= {1,2,3,};
		System.out.println(a);
		List<Integer>ll=new ArrayList<Integer>();
		ll.add(1);
		ll.add(5);
		System.out.println(ll);
		
	}
	 
	 @AfterTest(enabled = false)
	 public void tearDown() {
		 driver.quit();
		 
	 }
		
		
		
		
	



	

}
