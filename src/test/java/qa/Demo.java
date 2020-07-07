package qa;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pracice.QA.genricMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	List<String> ll = new ArrayList<String>();
	List<String> cartll = new ArrayList<String>();
	int count = 0;
	String text = "";
	public WebDriver driver;
	genricMethod gs = new genricMethod();
	Page page = new Page();

	@Test(enabled = false)
	public void run() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("https://qaclickacademy.github.io/protocommerce/");
		driver.findElement(By.linkText("Shop")).click();

		List<WebElement> allitems = driver.findElements(By.xpath("//div[@class='card-body']//a"));
		for (WebElement name : allitems) {
			System.out.println("the items are-->" + name.getText());
			if (name.getText().equalsIgnoreCase("Nokia Edge")) {
				driver.findElement(By.xpath("//a[.='Nokia Edge']/../../..//button[@class='btn btn-info']")).click();
				ll.add(name.getText());
				count++;
				continue;

			} else if (name.getText().equalsIgnoreCase("Samsung Note 8")) {
				driver.findElement(By.xpath("//a[.='Samsung Note 8']/../../..//button[@class='btn btn-info']")).click();
				ll.add(name.getText());
				count++;

			}
		}

		new WebDriverWait(driver, 120).until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']"))));
		text = driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).getText().replaceAll("[^0-9]",
				"");

		Assert.assertTrue(count == Integer.parseInt(text));
		System.out.println("the count from cart is--->" + text);
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

		new WebDriverWait(driver, 120).until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[@class='media-heading']//a"))));
		List<WebElement> cartitems = driver.findElements(By.xpath("//h4[@class='media-heading']//a"));
		for (WebElement cartitem : cartitems) {
			System.out.println("Cart item are-->" + cartitem.getText());
			cartll.add(cartitem.getText());

		}
		Assert.assertTrue(ll.containsAll(cartll));
		driver.close();

	}

	@Test(enabled = false)
	public void verifylinksandImages() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		if ((driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"))).isDisplayed()) {
			driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		}

		gs.toFindlink_Images(driver);
		driver.close();

	}

	@Test(enabled = false)
	public void urban() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.urbanladder.com/");
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		Assert.assertTrue(gs.window_Switch(driver), "validated successfully");
		driver.close();

	}

	@Test(enabled = false)
	public void rahul() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Assert.assertTrue(page.clear(driver));
		Assert.assertTrue(page.select(driver));
		// driver.close();

	}

	@Test(enabled = false)
	public void readData() throws Exception {

		Workbook wb = WorkbookFactory
				.create(new File("C:\\Users\\win10\\Desktop\\Selenium\\QA\\New Microsoft Office Excel Worksheet.xlsx"));
		Sheet sheet = wb.getSheet("Sheet1");
		int row = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < row; i++) {
			Row r = sheet.getRow(i);
			int cell = r.getPhysicalNumberOfCells();
			for (int j = 0; j < cell; j++) {
				Cell c = r.getCell(1);
				String data = c.getStringCellValue();
				System.out.print(data + "\t\t");

			}
			System.out.println();

		}
	}

	@Test(enabled = true)
	public void readData1() throws Exception {

		Workbook wb = WorkbookFactory
				.create(new File("C:\\Users\\win10\\Desktop\\Selenium\\QA\\New Microsoft Office Excel Worksheet.xlsx"));
		Sheet sheet = wb.getSheet("Sheet1");
		int value = sheet.getPhysicalNumberOfRows();
		Row row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			Cell data = row.getCell(i);
			System.out.print(data + "\t ");

		}

		System.out.println();

	}

	@Test
	public void selectbox() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		List<WebElement> all = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement name : all) {
			text = name.getAttribute("value");

			if (text.equalsIgnoreCase("option2")) {
				name.click();
			}

			else if (text.equalsIgnoreCase("option3")) {
				name.click();
			}

		}

	}

}
