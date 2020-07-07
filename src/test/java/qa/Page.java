package qa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page {
	
	public static final String  url="https:";
	
	public static final String ursername="rahul gaurav";
	
	public static final String password="1nc09cs045";
	
	
	public boolean clear(WebDriver driver) {
	List<WebElement> all = driver.findElements(By.xpath("//select[@id='dropdown-class-example']//option"));
	for(WebElement name : all) {
		System.out.println(name.getText());
		if((name.getText()).equalsIgnoreCase("Option2")) {
			System.out.println("found");
			return true;
			}
		
	}
	return false;
	
}
	public boolean select(WebDriver driver) {
		List<WebElement> all = new Select(driver.findElement(By.id("dropdown-class-example"))).getOptions();
		for(WebElement name : all) {
			System.out.println(name.getText());
			if((name.getText()).equalsIgnoreCase("Option2")) {
				System.out.println("found");
				return true;
				}
			
		}
		return false;
	}
}
