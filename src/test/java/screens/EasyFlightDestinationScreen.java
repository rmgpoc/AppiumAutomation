package screens;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import base.ScreenBase2;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EasyFlightDestinationScreen extends ScreenBase2{
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public EasyFlightDestinationScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/airport_query")
	public MobileElement airportQueryField;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/cancelButton")
	public MobileElement cancelBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/airport_code")
	public List<MobileElement> airportCode;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/airport_country")
	public List<MobileElement> airportCountries;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/airport_name")
	public List<MobileElement> airportNames;
	
	@AndroidFindBy(className="android.view.View")
	public List<MobileElement> airportClickableSelction;
	
	public void selectAirport(String country, String airport){
		airportQueryField.sendKeys(country);
		if(airportCountries.size()>1){
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+airport+"\").instance(0))").click();
		/*	try{
				while(true){
					for(MobileElement airportName: airportNames){
						if(airportName.getText().equals(airport)){
							airportName.click();
							break;
						}
					}
					driver.swipe(500, 1400, 500, 200, 20000);
				}
			}catch(Throwable t){
				t.printStackTrace();
				log.debug(t);
			}*/
		}else{
			airportCountries.get(0).click();
		}
	}
	
}
