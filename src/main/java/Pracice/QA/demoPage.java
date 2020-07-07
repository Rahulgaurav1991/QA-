package Pracice.QA;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class demoPage extends browserFactory {

	public demoPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="")

	@FindAll({ @FindBy(id = "rahul"), @FindBy(id = "gaurav") })
	private WebElement name;
	
	
	
	public void clickButton() {
		
		
	}

}
