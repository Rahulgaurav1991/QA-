package qa;

import org.testng.annotations.BeforeMethod;

public class B {
	public static void main(String[] args) {
		
		System.out.println("at main method ");
		
		
		
	}
	
	@BeforeMethod
	public void runner() {
		System.out.println("at before method ");
	}

}
