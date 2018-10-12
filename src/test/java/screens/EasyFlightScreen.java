package screens;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.TestUtil;

public class EasyFlightScreen extends ScreenBase{

	public EasyFlightScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(className="android.widget.TextView")
	public List<MobileElement> logPage;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/fare_button_standard")
	public MobileElement standardFareBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/fare_button_flexi")
	public MobileElement flexiFareBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/flight_times_departure_iata_text")
	public MobileElement departureTimePort;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/flight_times_departure_time_text")
	public MobileElement departureTime;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/flight_times_arrival_iata_text")
	public MobileElement arrivalTimePort;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/flight_times_arrival_time_text")
	public MobileElement arrivalTime;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/caption")
	public MobileElement caption;
	
	@AndroidFindBy(className="android.widget.LinearLayout")
	public List<MobileElement> multiFlightScheduleFrame;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/flight_panel_plane_father")
	public List<MobileElement> multiFlightSchedule;	
	
	
	public void standardFareBtn(){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/fare_button_standard");
		standardFareBtn.click();
	}
	
	public void flexiFareBtn(){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/fare_button_flexi");
		flexiFareBtn.click();
	}
	
	public void selectOutboundTicket(String fareType, int select) throws IOException{
		
		selectFareType(fareType, select);
	}
	
	public void selectInboundTicket(String fareType, int select) throws IOException{
		
		selectFareType(fareType, select);
	}
	
	public void selectFareType(String fareType, int select) throws IOException{
		log.debug("*******Testing is being executed on: " + logPage.get(1).getText().trim() + " Screen.*******");
		List<MobileElement> multiFlight = multiFlightScheduleFrame.get(select).findElementsById("com.mttnow.droid.easyjet:id/flight_panel_plane_father");
		List<MobileElement> multiFlightStandard = multiFlightScheduleFrame.get(select).findElementsById("com.mttnow.droid.easyjet:id/fare_button_standard");
		List<MobileElement> multiFlightFlexi = multiFlightScheduleFrame.get(select).findElementsById("com.mttnow.droid.easyjet:id/fare_button_flexi");		
		if(multiFlightStandard.size() > 1 || multiFlightFlexi.size() > 1){
			List<String> price = new ArrayList<String>();
			if(fareType == "Standard"){
				log.debug("*******Travel date is " + caption.getText()+"*******");
				List<MobileElement> selectStandard = multiFlightStandard.get(select).findElementsByClassName("android.widget.TextView");
					for(int i=0; i<selectStandard.size(); i++){
						price.add(selectStandard.get(select).getText());
						System.out.println(selectStandard.get(select).getText());
					}
					log.debug("*******Standard Ticket Cost is " + selectStandard.get(1).getText() + selectStandard.get(2).getText() +":"+ selectStandard.get(3).getText().trim() + ".*******");
					log.debug("*******Flight " + multiFlight.get(select).findElementById("com.mttnow.droid.easyjet:id/flight_times_departure_iata_text").getText() + " at " + multiFlight.get(select).findElementById("com.mttnow.droid.easyjet:id/flight_times_departure_time_text").getText() + " and " + multiFlight.get(select).findElementById("com.mttnow.droid.easyjet:id/flight_times_arrival_iata_text").getText() + " at " + multiFlight.get(select).findElementById("com.mttnow.droid.easyjet:id/flight_times_arrival_time_text").getText() + ".*******");
					multiFlight.get(select).findElementById("com.mttnow.droid.easyjet:id/fare_button_standard").click();
				}else if(fareType == "Flexi"){
					log.debug("*******Travel date is " + caption.getText()+"*******");
					List<MobileElement> selectFlexi = multiFlightFlexi.get(select).findElementsByClassName("android.widget.TextView");
					for(int i=0; i<selectFlexi.size(); i++){
						price.add(selectFlexi.get(select).getText());
						System.out.println(selectFlexi.get(select).getText());
					}
					log.debug("*******Flexi Ticket Cost is " + selectFlexi.get(1).getText() + selectFlexi.get(2).getText() +":"+ selectFlexi.get(3).getText().trim() + ".*******");
					log.debug("*******Flight " + multiFlight.get(select).findElementById("com.mttnow.droid.easyjet:id/flight_times_departure_iata_text").getText() + " at " + multiFlight.get(select).findElementById("com.mttnow.droid.easyjet:id/flight_times_departure_time_text").getText() + " and " + multiFlight.get(select).findElementById("com.mttnow.droid.easyjet:id/flight_times_arrival_iata_text").getText() + " at " + multiFlight.get(select).findElementById("com.mttnow.droid.easyjet:id/flight_times_arrival_time_text").getText() + ".*******");
					multiFlight.get(select).findElementById("com.mttnow.droid.easyjet:id/fare_button_flexi").click();
				}else{
					log.debug("*******Fare Type not selected.*******");
			}
			
		}else{
			List<String> price = new ArrayList<String>();
			if(fareType == "Standard"){
				log.debug("*******Travel date is " + caption.getText()+"*******");
				List<MobileElement> standardFare = standardFareBtn.findElementsByClassName("android.widget.TextView");
					for(int i=0; i<standardFare.size(); i++){
						price.add(standardFare.get(i).getText());
						System.out.println(standardFare.get(i).getText());
					}
					log.debug("*******Standard Ticket Cost is " + standardFare.get(1).getText() + standardFare.get(2).getText() +":"+ standardFare.get(3).getText().trim() + ".*******");
					log.debug("*******Flight " + departureTimePort.getText() + " at " + departureTime.getText() + " and " +  arrivalTimePort.getText() + " at " + arrivalTime.getText() + ".*******");
					TestUtil.takeScreenShot();
					standardFareBtn();
				}else if(fareType == "Flexi"){
					log.debug("*******Travel date is " + caption.getText()+"*******");
					List<MobileElement> flexiFare = flexiFareBtn.findElementsByClassName("android.widget.TextView");
					for(int i=0; i<flexiFare.size(); i++){
						price.add(flexiFare.get(i).getText());
						System.out.println(flexiFare.get(i).getText());
					}
					log.debug("*******Flexi Ticket Cost is " + flexiFare.get(1).getText() + flexiFare.get(2).getText() +":"+ flexiFare.get(3).getText().trim() + ".*******");
					log.debug("*******Flight " + departureTimePort.getText() + " at " + departureTime.getText() + " and " +  arrivalTimePort.getText() + " at " + arrivalTime.getText() + ".*******");
					TestUtil.takeScreenShot();
					flexiFareBtn();
				}else{
					log.debug("*******Fare Type not selected.*******");
			}
		}		
				
	}

}
