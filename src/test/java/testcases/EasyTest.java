package testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
import screens.EasyPassengerDetailsScreen;
import screens.EasyTravelSportsEquipmentScreen;
import utility.TestUtil;

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
	EasyPassengerDetailsScreen easyPassengerDetailsScreen;
	
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
		easyPassengerDetailsScreen = new EasyPassengerDetailsScreen((AndroidDriver<MobileElement>) driver);
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
		easyCalendar.selectTravelDate("Return", "November 2018", "5", "November 2018", "18");
		easyBookFlight.addPassenger("2", "2", "2");
		easyPassenger.addPassengerCount("2", "2", "2");
		easyBookFlight.showFlightsButton();
		easyGoingOut.selectOutboundTicket("Standard", "1");
		easyGoingOut.selectInboundTicket("Standard", "1");
		easyAddExtraScreen.addBag15kg("1");
		easyAddExtraScreen.addBag23kg("2");
		easyAddExtraScreen.getLuggagePrice();
		easyAddExtraScreen.addSportsEquipBtn();
		easyTravelSportsEquipmentScreen.addSportsEquipment("0", "1", "0", "0", "0", "1", "0", "0", "0");
		easyAddExtraScreen.finalPrice();
		easyPassengerDetailsScreen.getPassengers();
		//easyPassengerDetailsScreen.addAdultPassengerDetails("Mr", "Mark", "West", "18+");
		//easyPassengerDetailsScreen.addChildPassengerDetails("Ms", "Sam", "West", "15");
		//easyPassengerDetailsScreen.addInfantPassengerDetails("Malcolm", "West");
		easyPassengerDetailsScreen.homeLogo();
	}
	
	/*@Test(dataProvider="getData", priority=2)
	public void oneAdultOneChildRtn(String journeyType, String departureCountry, String departureAirport, String destinationCountry, String destinationAirport, String departureMonthYear, String departureDay, String returnMonthYear, String returnDay, String adultCount, String childCount, String infantCount, String outboundTicketType, String inboundTicketType, String selectDisplayedTicket, String addBag15kg, String addBag23kg, String addGolfEquipment20kg, String addSkiEquipment20kg, String addSnowboardEquipment20kg, String addSportFirearmsEquipment20kg, String addOtherSmallSportsEquipment20kg, String addBicycleEquipment32kg, String addCanoeEquipment32kg, String addWindSurferEquipment32kg, String addHangGliderEquipment32kg) throws IOException {
		log.debug("########Executing TC2 - Purchase One Adult One Child Return Ticket TestCase########");
		easyHome.clickBookBtn();
		easyBookFlight.journeyType(journeyType);
		easyFlightDestination.selectAirport(departureCountry, departureAirport);
		easyBookFlight.destinationBtn();
		easyFlightDestination.selectAirport(destinationCountry, destinationAirport);
		easyBookFlight.departingDate();
		easyCalendar.selectTravelDate(journeyType, departureMonthYear, departureDay, returnMonthYear, returnDay);
		easyBookFlight.addPassenger(adultCount, childCount, infantCount);
		easyPassenger.addPassengerCount(adultCount, childCount, infantCount);
		easyBookFlight.showFlightsButton();
		easyGoingOut.selectOutboundTicket(outboundTicketType, selectDisplayedTicket);
		easyGoingOut.selectInboundTicket(inboundTicketType, selectDisplayedTicket);
		easyAddExtraScreen.addBag15kg(addBag15kg);
		easyAddExtraScreen.addBag23kg(addBag23kg);
		easyAddExtraScreen.getLuggagePrice();
		easyAddExtraScreen.addSportsEquipBtn();
		easyTravelSportsEquipmentScreen.addSportsEquipment(addGolfEquipment20kg, addSkiEquipment20kg, addSnowboardEquipment20kg, addSportFirearmsEquipment20kg, addOtherSmallSportsEquipment20kg, addBicycleEquipment32kg, addCanoeEquipment32kg, addWindSurferEquipment32kg, addHangGliderEquipment32kg);
		easyAddExtraScreen.finalPrice();
	}
	@DataProvider
	public static Object[][] getData(){
		
		return TestUtil.getExcelData("EasyTest");				
	}*/

}
