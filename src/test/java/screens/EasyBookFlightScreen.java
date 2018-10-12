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

public class EasyBookFlightScreen extends ScreenBase{
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public EasyBookFlightScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(className="android.support.v7.app.b")
	public List<MobileElement> flightTypeBtns;
	
	@AndroidFindBy(className="android.widget.TextView")
	public List<MobileElement> logPage;
	
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
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/adultsCounterNumberText")
	public MobileElement addAdultCountText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/plusButton")
	public MobileElement addAdultCount;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/minusButton")
	public MobileElement minusAdultCount;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/childrenAndInfantCompoundedText")
	public MobileElement childrenAndInfantBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/showFlightsButton")
	public MobileElement showFlightsButton;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/holidaysButton")
	public MobileElement showPackageHolidayBtn;
	
	
	public void oneWayTrip(){
		flightTypeBtns.get(1).click();
	}
	
	public void returnTrip(){
		flightTypeBtns.get(0).click();
	}
	
	public void journeyType(String journeyType){
		if(journeyType=="Return"){
			log.debug("*******Testing is being executed on: " + logPage.get(0).getText().trim() + " Screen.*******");
			departureBtn();
		}else{
			oneWayTrip();
			log.debug("*******Testing is being executed on: " + logPage.get(0).getText().trim() + " Screen.*******");
			departureBtn();
		}
	}
	
	public void departureBtn(){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/departureAirportCompoundedText");
		departureField.click();
	}
	
	public void destinationBtn(){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/destinationAirportCompoundedText");
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
		returnFlightAirportsSelected();
		departingDateField.click();
	}
	
	public void returningDate(){
		returningDateField.click();
	}
	
	public void addAdultCount(){
		addAdultCount.click();
	}
	
	public void addAdultNumber(int adultCount){
		int countAdult = Integer.parseInt(addAdultCountText.getText());
		if (countAdult<adultCount){
			addAdultCount(adultCount);
		}else if (countAdult>adultCount){
			minusAdultCount(adultCount);
		}
	}
	
	public void addAdultCount(int adultCount){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/plusButton");
			for(int i=1; i<adultCount; i++){
				addAdultCount.click();			
			}

	}
	
	public void minusAdultCount(int adultCount){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/minusButton");
		int countAdult = Integer.parseInt(addAdultCountText.getText());
		for(int i=countAdult; i>adultCount; i--){
			minusAdultCount.click();			
		}		
	}
	
	public void childrenAndInfantBtn(){
		childrenAndInfantBtn.click();
	}
	
	public void addPassenger(int adultCount, int childCount, int infantCount){
		if(adultCount==1 && childCount==0 && infantCount == 0){
			log.debug("*******Single Adult FLight*******");
		}else if(adultCount>1 && childCount==0 && infantCount == 0){
			addAdultNumber(adultCount);
		}else{
			childrenAndInfantBtn();
		}		
		
	}
	
	public void showFlightsButton(){
		showFlightsButton.click();
	}
	
	public void showPackageHolidayBtn(){
		showPackageHolidayBtn.click();
	}

}
