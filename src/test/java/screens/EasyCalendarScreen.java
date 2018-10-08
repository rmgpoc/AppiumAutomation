package screens;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EasyCalendarScreen extends ScreenBase{
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public EasyCalendarScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		//(AndroidDriver<MobileElement> driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/calendarView")
	public MobileElement calendarView;
	
	@AndroidFindBy(className="android.widget.LinearLayout")
	public List<MobileElement> monthView;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/title")
	public List<MobileElement> monthYearTitles;
	
	@AndroidFindBy(className="android.widget.FrameLayout")
	public List<MobileElement> dateFrameLayouts;
	
	@AndroidFindBy(className="android.widget.TextView")
	public List<MobileElement> dateTextViews;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/doneButton")
	public MobileElement doneBtn;
	
	public void doneButton(){
		doneBtn.click();
	}
	
	public MobileElement getMonth(String monthYearString){
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+monthYearString+"\").instance(0))");
		List<MobileElement> monthFrames = calendarView.findElementsByClassName("android.widget.LinearLayout");			
		for(MobileElement month : monthFrames){
			for(MobileElement t : month.findElementsByClassName("android.widget.TextView")){
				if(t.getText().equals(monthYearString)){					
					return month;
				}
			}		
		}
			return null;		
	}
	
	public static void selectDay(MobileElement month, String dayToSelect){
		for(MobileElement date : month.findElementsByClassName("android.widget.TextView")){
			if(date.getText().equals(dayToSelect)){		
				date.click();				
				return;
			}			
		}		
	}

}