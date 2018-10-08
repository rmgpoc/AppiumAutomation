package listener;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utility.TestUtil;

public class CustomListeners implements ITestListener, ISuiteListener{
	
	public static Logger log = Logger.getLogger("devpinoyLogger");

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		log.debug("***** Error " + result.getName() + " test has failed *****");
		System.out.println("***** Error " + result.getName() + " test has failed *****");
		System.out.println("Screenshot Captured");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		//Reporter.log("Test Failed - Captured Screenshot");
		try {
			TestUtil.takeScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//Reporter.log("<a target=\"_blank\" href=\""+"screenshots/"+TestUtil.destFile+"\">Screenshot Captured</a>");
		Reporter.log("<a target=\"_blank\" href=\""+TestUtil.mailscreenshotpath+"\">Screenshot Captured</a>");
		Reporter.log("<br><a target='_blank' href=\""+TestUtil.mailscreenshotpath+"\"><img height=200, width=200, src=\""+TestUtil.mailscreenshotpath+"\" alt=\"\"/></img></a>");
				
		//String path1 = ("<br><a target='_blank' href=\""+"screenshots/"+TestUtil.destFile+"\"><img height=200, width=200, src=\""+"screenshots/"+TestUtil.destFile+"\" alt=\"\"/></img></a>");	//
		//Reporter.log(path1);
		//Reporter.log("<a target=\"_blank\" href=\"abcd.jpg\">Screenshot Log captured</a>");
		//Reporter.log("<a href=\"abcd.jpg\">Screenshot Log captured</a>");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Starting the Test Suite");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Ending the Test Suite");
		
	}

	public void onStart(ISuite suite) {
		System.out.println("Starting");
		
	}

	public void onFinish(ISuite suite) {
		System.out.println("Finishing");
		
	}

}
