package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {
	
	
	private static Properties prop = new Properties();
	public static int EXPLICIT_WAIT_TIME;
	public static int IMPLICIT_WAIT_TIME;
	public static String APP_PATH;
	public static String BASE_PKG;
	public static String APP_ACTIVITY;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String AUTOMATION_INSTRUMENTATION;
	public static String APPIUM_PORT;
	public static String ACCEPT_ALERT;
	public static String DISMISS_ALERT;

	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	private static URL serverUrl;
	private static AppiumDriver<MobileElement> driver;
	
	public static void loadAndroidConfigProp(String propertyFileName) throws IOException{
		//Loading the properties file
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/"+propertyFileName);
		prop.load(fis);
		
		//Initialising the properties
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		//APP_PATH = prop.getProperty("application.path");
		BASE_PKG = prop.getProperty("base.pkg");
		APP_ACTIVITY = prop.getProperty("application.activity");
		APPIUM_PORT = prop.getProperty("appium.server.port");
		AUTOMATION_INSTRUMENTATION = prop.getProperty("automation.instumentation");
		DEVICE_NAME = prop.getProperty("device.name");
		BROWSER_NAME = prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		ACCEPT_ALERT = prop.getProperty("auto.acceptalerts");
		DISMISS_ALERT = prop.getProperty("auto.dismissalerts");

	 }
	
	public static void setAndroidCapabilities() {
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_INSTRUMENTATION);
		//capabilities.setCapability(MobileCapabilityType.APP, CommonUtils.APP_PATH);
		capabilities.setCapability(MobileCapabilityType.APP, APP_PATH);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
		//capabilities.setCapability(AndroidMobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, ACCEPT_ALERT);
		capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, DISMISS_ALERT);
	}

	public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException {
		serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");		
		driver = new AndroidDriver<MobileElement>(serverUrl, capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;

	}	
	
	/*public static void loadIOSConfigProp(String propertyFileName) throws IOException{
		//Loading the properties file
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/"+propertyFileName);
		prop.load(fis);
		
		//Initialising the properties
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		//APP_PATH = prop.getProperty("application.path");
		BASE_PKG = prop.getProperty("base.pkg");
		APP_ACTIVITY = prop.getProperty("application.activity");
		APPIUM_PORT = prop.getProperty("appium.server.port");
		AUTOMATION_INSTRUMENTATION=prop.getProperty("automation.instumentation");
		DEVICE_NAME=prop.getProperty("device.name");
		BROWSER_NAME=prop.getProperty("browser.name");
		PLATFORM_NAME=prop.getProperty("platform.name");
		PLATFORM_VERSION=prop.getProperty("platform.version");
		ACCEPT_ALERT = prop.getProperty("auto.acceptalerts");
		DISMISS_ALERT = prop.getProperty("auto.dismissalerts");
	
}

	public static void setIOSCapabilities() {
		capabilities.setCapability(IOSMobileCapabilityType.BROWSER_NAME, BROWSER_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_INSTRUMENTATION);
		//capabilities.setCapability(MobileCapabilityType.APP, CommonUtils.APP_PATH);
		capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, BASE_PKG);
		capabilities.setCapability(MobileCapabilityType.UDID, APP_ACTIVITY);
		//capabilities.setCapability(AndroidMobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, ACCEPT_ALERT);
		capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, DISMISS_ALERT);
	}
	
	
	public static AppiumDriver<MobileElement> getIOSDriver() throws MalformedURLException {
		serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");		
		driver = new IOSDriver<MobileElement>(serverUrl, capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
*/
	

}
