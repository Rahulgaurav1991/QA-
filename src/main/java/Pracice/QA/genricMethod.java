package Pracice.QA;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class genricMethod {
	
	
	public String response="";
	
	
	public void toFindlink_Images( WebDriver driver) {
		
		try {
		List<WebElement>list =new ArrayList<WebElement>();
		List<WebElement> links = driver.findElements(By.tagName("a")); // all link tags .
		links.addAll(driver.findElements(By.tagName("img")));// all img tags inside link tags.
		//to get the size of all links and images 
		System.out.println("Total links and images are there-->"+links.size());
		for(WebElement name:links) {
			System.out.println("the links are --->"+name.getAttribute("href"));
			if(name.getAttribute("href")!=null) {// exclude all links and images which doesn't have href attrubute.
				
				list.add(name);
			}
		}
		//to get size of Activelinks
		System.out.println("the size of active links are-->"+list.size());
		
		// to verify links code ..
		for(WebElement activeLinks:list) {
			HttpURLConnection connnection=(HttpURLConnection)new URL(activeLinks.getAttribute("href")).openConnection();
			connnection.connect();
			response=connnection.getResponseMessage();
			connnection.disconnect();
			System.out.println(activeLinks.getAttribute("href") +"---->"+response);
	}
		
		
		
	
	}

	catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	
	public boolean window_Switch(WebDriver driver) {
		List<String>ll =new ArrayList<String>();
		List<String> present=new ArrayList<String>();
		present.add("Urban Ladder - Furniture | Facebook - 5,083 photos");
		present.add("Urban Ladder (@UrbanLadder) | Twitter");
		present.add("Urban Ladder (urbanladder) on Pinterest");
		present.add("Urban Ladder Furniture Store - Domlur - YouTube");
		present.add("Urban Ladder (@urbanladder) • Instagram photos and videos");
		present.add("Urban Ladder | LinkedIn");
		try {
			new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='close-reveal-modal hide-mobile']")));
			new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='close-reveal-modal hide-mobile']"))).click();
			new Actions(driver).moveToElement(driver.findElement(By.id("footer-social"))).perform();
			new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='footer-social']//li//a")));
			List<WebElement> allinks = driver.findElements(By.xpath("//ul[@id='footer-social']//li//a"));
			for(int i=3;i<=allinks.size();i++) {
				List<WebElement> link = driver.findElements(By.xpath("//ul[@id='footer-social']//li["+i+"]//a"));
				for(WebElement name:link) {
					name.click();
					String parent = driver.getWindowHandle();
					Set<String> child = driver.getWindowHandles();
					for(String childWindow:child) {
						if(!(parent.equalsIgnoreCase(childWindow))) {
							driver.switchTo().window(childWindow);
							System.out.println("the title of Web page is-->"+driver.getTitle());
							ll.add(driver.getTitle());
							driver.close();
						}
					}
					driver.switchTo().window(parent);
						
					}
			}
			if(ll.containsAll(present)) {
				return true;
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
			return false;
							
					
			
	}
				
	public void verification(WebDriver driver) {
	//WebElement facebook = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/urbanladder/']"));
	//WebElement twitter=driver.findElement(By.xpath("//a[@href='/UrbanLadder']"));
	//Assert.((driver.findElement(By.xpath("//a[@href='/UrbanLadder']"))).isDisplayed()||(driver.findElement(By.xpath("//a[@href='https://www.facebook.com/urbanladder/']"))).isDisplayed());
	}
	
	
	
	
	

}
