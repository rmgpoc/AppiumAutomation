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

public class EasyBookFlight extends ScreenBase{
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public EasyBookFlight(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(className="android.support.v7.app.b")
	public List<MobileElement> flightTypeBtns;
	
	@AndroidFindBy(className="android.widget.TextView")
	public List<MobileElement> flightTypeLabels;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/departureAirportCompoundedText")
	public MobileElement departureField;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/destinationAirportCompoundedText")
	public MobileElement destinationField;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/closeDepartureAirportButton")
	public MobileElement deleteDepartureAirportBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/closeDestinationAirportButton")
	public MobileElement deleteDestinationAirportBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/swapAirportsButton")
	public MobileElement swapAirportBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/departingDateCompoundedText")
	public MobileElement departingDateField;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/returningDateCompoundedText")
	public MobileElement returningDateField;
	
	public void oneWayTrip(){
		flightTypeBtns.get(1).click();
	}
	
	public void returnTrip(){
		flightTypeBtns.get(0).click();
	}
	
	public void departureBtn(){
		departureField.click();
	}
	
	public void destinationBtn(){
		destinationField.click();
	}
	
	public void swapDepartureAndDestinationAirport(){
		swapAirportBtn.click();
	}
	
	public void returnFlightAirportsSelected(){
		if(flightTypeBtns.get(0).isSelected() && deleteDepartureAirportBtn.isDisplayed() && deleteDestinationAirportBtn.isDisplayed()){
			log.debug("*******Return Flight Travel Airports have been selected*******");
		}else if(flightTypeBtns.get(1).isSelected() && deleteDepartureAirportBtn.isDisplayed() && !deleteDestinationAirportBtn.isDisplayed()){
			log.debug("*******One Way Flight Airport has been selected*******");
		}else if(flightTypeBtns.get(0).isSelected() && !deleteDepartureAirportBtn.isDisplayed() && deleteDestinationAirportBtn.isDisplayed()){
			log.debug("*******Departure Airport has not been selected*******");
		}else{
			log.debug("*******Travel Flight Airports have not been selected*******");
		}
	}
	
	public void departingDate(){
		departingDateField.click();
	}
	
	public void returningDate(){
		returningDateField.click();
	}

}
