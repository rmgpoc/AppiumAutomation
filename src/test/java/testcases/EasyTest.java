package testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import screens.EasyAddExtraScreen;
import screens.EasyBookFlightScreen;
import screens.EasyCalendarScreen;
import screens.EasyFlightDestinationScreen;
import screens.EasyFlightScreen;
import screens.EasyHomeScreen;
import screens.EasyPassengerCountScreen;
import screens.EasyTravelSportsEquipmentScreen;

public class EasyTest extends TestBase{
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	

	EasyHomeScreen easyHome;
	EasyBookFlightScreen easyBookFlight;
	EasyFlightDestinationScreen easyFlightDestination;
	EasyCalendarScreen easyCalendar;
	EasyPassengerCountScreen easyPassenger;
	EasyFlightScreen easyGoingOut;
	EasyAddExtraScreen easyAddExtraScreen;
	EasyTravelSportsEquipmentScreen easyTravelSportsEquipmentScreen;
	
	@BeforeTest
	public void init() throws InterruptedException, IOException{
		easyHome = new EasyHomeScreen(driver);
		easyBookFlight = new EasyBookFlightScreen(driver);
		easyFlightDestination = new EasyFlightDestinationScreen((AndroidDriver<MobileElement>) driver);
		easyCalendar = new EasyCalendarScreen((AndroidDriver<MobileElement>) driver);
		easyPassenger = new EasyPassengerCountScreen(driver);
		easyGoingOut = new EasyFlightScreen(driver);
		easyAddExtraScreen = new EasyAddExtraScreen((AndroidDriver<MobileElement>) driver);
		easyTravelSportsEquipmentScreen = new EasyTravelSportsEquipmentScreen(driver);
	}
	
	@Test(priority=1)
	public void oneAdultOneChildRtn(ITestContext context) throws IOException {
		log.debug("########Executing TC1 - Purchase One Adult One Child Return Ticket TestCase########");
		easyHome.clickBookBtn();
		easyBookFlight.journeyType("Return");
		easyFlightDestination.selectAirport("United Kingdom", "London Luton");
		easyBookFlight.destinationBtn();
		easyFlightDestination.selectAirport("United Kingdom", "Belfast Intl");
		easyBookFlight.departingDate();
		easyCalendar.selectTravelDate("Return", "October 2018", "22", "October 2018", "31");
		easyBookFlight.addPassenger(1, 1, 0);
		easyPassenger.addPassengerCount(1, 1, 0);
		easyBookFlight.showFlightsButton();
		easyGoingOut.selectOutboundTicket("Standard", 1);
		easyGoingOut.selectInboundTicket("Standard", 1);
		easyAddExtraScreen.addBag15kg(1);
		easyAddExtraScreen.addBag23kg(2);
		easyAddExtraScreen.getLuggagePrice();
		easyAddExtraScreen.addSportsEquipBtn();
		easyTravelSportsEquipmentScreen.addSportsEquipment(0, 1, 0, 0, 0, 1, 0, 0, 0);
		easyAddExtraScreen.finalPrice();
	}

}
