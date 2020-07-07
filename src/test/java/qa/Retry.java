package qa;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	public boolean retry(ITestResult result) {
		int count=0;
		int retry=3;
		if(count<retry) {
			count++;
			return true;
			
		}
		return false;
		
		
	
		
	}
	
	
	
	
	

}
