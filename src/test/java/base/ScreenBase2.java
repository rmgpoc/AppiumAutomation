package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScreenBase2 {
	
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public ScreenBase2(AndroidDriver<MobileElement> driver){
		
		this.driver = driver;
	}
	
	public void waitforElementPresence(long duration, String locator){
		
		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));		
	}
	
	public void waitforEleClassNamePresence(long duration, String locator){
		
		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));		
	}
	
	public void waitforElementClickable(long duration, String locator){
		
		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));		
	}
	
	public void hideKeyboard(){
		
		driver.hideKeyboard();
	}

}
