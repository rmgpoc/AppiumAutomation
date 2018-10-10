package rough;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class rough {
	
	public static AndroidDriver<MobileElement> driver;
	public static AppiumDriverLocalService service;
	
	public static boolean isElementPresent (String id){
		try{
			driver.findElement(By.id(id));
			return true;
		}catch(Throwable t){
			return false;
		}
		
	}
	public static String departureAirportCode = "LTN";
	public static String destinationAirportCode = "ALC";

	public static void main(String[] args) throws Exception {
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\ugbene.ositadinma\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt")));
		service.start();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "samsung-nexus-127.0.0.1:62001");
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "4.4.2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "NoxPlayer");
		capabilities.setCapability("appPackage", "com.mttnow.droid.easyjet");
		capabilities.setCapability("appActivity", "com.mttnow.droid.easyjet.ui.home.MainActivity");
		capabilities.setCapability("newCommandTimeout", 120);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		driver.findElementById("com.mttnow.droid.easyjet:id/bottom_nav_book").click();
		List <MobileElement> flights = driver.findElementsByClassName("android.support.v7.app.b");
		flights.get(1).click();
		Thread.sleep(2000);
		flights.get(0).click();
//		driver.findElementById("com.mttnow.droid.easyjet:id/departureAirportCompoundedText").click();
//		driver.findElementById("com.mttnow.droid.easyjet:id/airport_query").sendKeys("United Kingdom");
//		List <MobileElement> airportCountries = driver.findElementsById("com.mttnow.droid.easyjet:id/airport_country");
//		List <MobileElement> airportNames = driver.findElementsById("com.mttnow.droid.easyjet:id/airport_name");
//		if(airportCountries.size()>1){
//			try{
//				while(true){
//					for(MobileElement airport: airportNames){
//						if(airport.getText().equals("London Luton")){
//							airport.click();
//							break;
//						}
//					}
//					driver.swipe(500, 1400, 500, 200, 20000);
//				}
//			}catch(Throwable t){
//				t.printStackTrace();
//			}
//		}else{
//			airportCountries.get(0).click();
//		}
//
////		for(MobileElement airportName: airportNames){
////			if(airportName.getText().equals("London Luton")){
////				airportName.click();
////				break;
////			}
////		}
//		//driver.findElementById("com.mttnow.droid.easyjet:id/airport_code").click();Bordeaux
//		//List <MobileElement> airports = driver.findElementsByClassName("android.view.View");
//		//airports.get(0).click();
//		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.mttnow.droid.easyjet:id/airport_code\")).scrollIntoView(new UiSelector().textContains(\""+departureAirportCode+"\"))").click();
////		List <MobileElement> airports = driver.findElementsById("com.mttnow.droid.easyjet:id/airport_code");
////		for(MobileElement airport: airports){
////			if(airport.getText().equals(departureAirportCode)){
////				airport.click();
////			}
////		}
//		driver.findElementById("com.mttnow.droid.easyjet:id/destinationAirportCompoundedText").click();
//		driver.findElementById("com.mttnow.droid.easyjet:id/airport_query").sendKeys("Spain");
//		List <MobileElement> airports = driver.findElementsById("com.mttnow.droid.easyjet:id/airport_name");
//		try{
//			while(true){
//				for(MobileElement airport: airports){
//					if(airport.getText().equals("Valencia")){
//						airport.click();
//						break;
//					}
//				}
//				driver.swipe(500, 1400, 500, 200, 20000);
//			}
//		}catch(Throwable t){
//			t.printStackTrace();
//		}
//		
//		if(flights.get(0).isSelected() && driver.findElementById("com.mttnow.droid.easyjet:id/closeDepartureAirportButton").isDisplayed() && driver.findElementById("com.mttnow.droid.easyjet:id/closeDestinationAirportButton").isDisplayed()){
//			System.out.println("*******Return Flight Travel Airports have been selected*******");
//		}else if(flights.get(1).isSelected() && driver.findElementById("com.mttnow.droid.easyjet:id/closeDepartureAirportButton").isDisplayed() && !driver.findElementById("com.mttnow.droid.easyjet:id/closeDestinationAirportButton").isDisplayed()){
//			System.out.println("*******One Way Flight Airport has been selected*******");
//		}else if(flights.get(0).isSelected() && !driver.findElementById("com.mttnow.droid.easyjet:id/closeDepartureAirportButton").isDisplayed() && driver.findElementById("com.mttnow.droid.easyjet:id/closeDestinationAirportButton").isDisplayed()){
//			System.out.println("*******Departure Airport has not been selected*******");
//		}else{
//			System.out.println("*******Travel Flight Airports have not been selected*******");
//		}
//		
		
		driver.findElementById("com.mttnow.droid.easyjet:id/departingDateCompoundedText").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"CLEAR\")").click();
		
		String departureMonth = "December 2018";
		String departureDay = "14";
		String returningMonth = "February 2019";
		String returningDay = "12";
		//MobileElement dmth = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+departureMonth+"\").instance(0))");
	
		
		MobileElement fromMonth = getMonth(departureMonth);		
		selectDay(fromMonth, departureDay);
		
		MobileElement toMonth = getMonth(returningMonth);		
		selectDay(toMonth, returningDay);		
		

	
		driver.findElementById("com.mttnow.droid.easyjet:id/doneButton").click();

	}
	
	public static MobileElement getMonth(String dateString){
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+dateString+"\").instance(0))");
		
		MobileElement listView = driver.findElementById("com.mttnow.droid.easyjet:id/calendarView");
		
		List<MobileElement> monthFrames = listView.findElementsByClassName("android.widget.LinearLayout");		
		
		for(MobileElement m : monthFrames){
			for(MobileElement t : m.findElementsByClassName("android.widget.TextView")){
				if(t.getText().equals(dateString)){					
					
					return  m;
				}
			}
			
		}
		return null;		
	}
	
	public static void selectDay(MobileElement month, String dayToSelect){
		for(MobileElement d : month.findElementsByClassName("android.widget.TextView")){
			if(d.getText().equals(dayToSelect)){		
				d.click();				
				return;
			}			
		}		
	}
}
