package base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utility.AppiumServer;
import utility.BlueStacksEmulator;
import utility.CommonUtils;
import utility.ExcelReader;
import utility.MyScreenRecorder;
import utility.NoxPlayerEmulator;

public class TestBase {
	
	public static AppiumDriver<MobileElement> driver;
	public static String loadPropertyFile = "Android_Easy.properties";//modify for other apps
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/testdata/testdata.xlsx");//modify for other apps
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void setUp() throws IOException, InterruptedException {
		
		MyScreenRecorder.start();
		log.debug("Screen Recorder Started");
		NoxPlayerEmulator.start();
		log.debug("NoxPlayer Emulator Started");
//		BlueStacksEmulator.start();
//		log.debug("BlueStacks Emulator Started");

		if (driver == null) {
			AppiumServer.start();
			log.debug("Appium Server Started");

			if (loadPropertyFile.startsWith("IOS")) {

				log.debug("Loading IOS Proprties file and Starting IOS Application");
				/*
				 * CommonUtils.loadIOSConfigProp(loadPropertyFile);
				 * CommonUtils.setIOSCapabilities(); 
				 * driver = CommonUtils.getIOSDriver();
				 */

			} else if (loadPropertyFile.startsWith("Android")) {

				log.debug("Loading Android Properties file and Starting Android Application");
				CommonUtils.loadAndroidConfigProp(loadPropertyFile);
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();
			}

		}

	}
	
	@AfterSuite
	public void tearDown() throws IOException, InterruptedException {

		Thread.sleep(3000);
		driver.quit();
		AppiumServer.stop();
		log.debug("Appium Server Stopped");
		NoxPlayerEmulator.stop();
		log.debug("NoxPlayer Emulator Stopped");
//		BlueStacksEmulator.stop();
//		log.debug("BlueStacks Emulator Stopped");
		MyScreenRecorder.stop();
		log.debug("Screen Recorder Stopped");

	}

}
