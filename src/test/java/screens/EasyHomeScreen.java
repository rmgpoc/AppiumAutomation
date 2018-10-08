package screens;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EasyHomeScreen extends ScreenBase{
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public EasyHomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/bottom_nav_home")
	public MobileElement bottomNavHomeBtn;
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/bottom_nav_book")
	public MobileElement bottomNavBookBtn;
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/bottom_nav_trips")
	public MobileElement bottomNavTripsBtn;
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/bottom_nav_passes")
	public MobileElement bottomNavPassesBtn;
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/bottom_nav_track")
	public MobileElement bottomNavTrackBtn;
	
	public void clickHomeBtn(){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/bottom_nav_home");
		bottomNavHomeBtn.click();
	}
	public void clickBookBtn(){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/bottom_nav_book");
		bottomNavBookBtn.click();
	}
	public void clickTripsBtn(){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/bottom_nav_trips");
		bottomNavTripsBtn.click();
	}
	public void clickPassesBtn(){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/bottom_nav_passes");
		bottomNavPassesBtn.click();
	}
	public void clickTrackBtn(){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/bottom_nav_track");
		bottomNavTrackBtn.click();
	}

}
