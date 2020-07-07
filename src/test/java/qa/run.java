package qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class run implements Rahul {
	
	@Test(enabled = false)
	public void call() {
		System.out.println(Rahul.url);
	}
	
	
	@Test(enabled = false)
	public void calling() {
		System.out.println(Page.password);
	}
	
	@Test(enabled = false)
	public void prime() {
		
		int n=7;
		int count=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				count++;
				
			}
		}
		if(count==2) {
			System.out.println("prime");
		}
		else {
			System.out.println("not a prime");
		}
	}
	
	@Test(enabled = false)
	public void sorting() {
		
		
		
		int a[]= {100,101,5,10};
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				int temp=0;
				temp=a[i];
				if(a[i]<a[j]) {
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		for(int x:a) {
			System.out.println(x);
		}
		
	}
	
	
	@Test(enabled = false)
	public void number() {
		Assert.fail();
		
		
		String s="i love india";
		String[] str = s.split(" ");
		
		String largest=str[0];
		//System.out.println(largest.length());
		String small=str[0];
		for(int i=0;i<str.length;i++) {
			if(str[i].length()>largest.length()) {
				largest=str[i];
			break;
			}
			else if(str[i].length()>small.length()) {
				small=str[i];
			}
			
				
			
		}
		System.out.println("the largest is --->"+largest);
		Assert.fail();
		
		
	}
	
	@Test(enabled = false)
	public void replace() {
		String s="$120.00";
		String value=s.substring(1,7).toString();
		System.out.println(value);
		System.out.println(s.replaceAll("\\$",""));
		String[] str=s.split("");
		for(int i=1;i<str.length;i++) {
			System.out.print(str[i]);
		}
		
		
	}
	@Test
	public void facebook() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.findElement(By.id("email")).sendKeys("rahul");
		System.out.println(driver.findElement(By.id("email")).getAttribute("value"));
				
	}


}
