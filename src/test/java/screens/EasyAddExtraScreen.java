package screens;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.apache.log4j.Logger;

import base.ScreenBase2;
import screens.EasyPassengerCountScreen;
import screens.EasyTravelSportsEquipmentScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EasyAddExtraScreen extends ScreenBase2{
	
	public static Double calculatedLuggageCost;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public EasyAddExtraScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/plus_btn")
	public MobileElement plusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/minus_btn")
	public MobileElement minusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/count_text")
	public MobileElement countText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/hold_luggage_price")
	public MobileElement luggagePriceText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/plusNumberPickerView")
	public List<MobileElement> plusNumberPickerView;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/title")
	public MobileElement title;
	
	@AndroidFindBy(className="android.widget.ScrollView")
	public List<MobileElement> scrollView;
	
	@AndroidFindBy(className="android.widget.LinearLayout")
	public List<MobileElement> linearLayout;
	
	@AndroidFindBy(className="android.widget.TextView")
	public List<MobileElement> textView;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/sports_equip_frg_sports_button")
	public MobileElement addSportsEquip;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/text")
	public MobileElement sportsEquipText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/price")
	public MobileElement sportsEquipPrice;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/priceText")
	public MobileElement priceText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/header_box")
	public List<MobileElement> fareBreakDownLink;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/pricingBreakDownLink")
	public MobileElement pricingBreakDownLink;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/submitButton")
	public MobileElement passengerDetailsSubmitBtn;
	
	public void logPage(){
		List<String> price = new ArrayList<String>();
		List<MobileElement> selectFlexi = linearLayout.get(2).findElementsByClassName("android.widget.TextView");
		for(int i=0; i<selectFlexi.size(); i++){
			price.add(selectFlexi.get(i).getText());
			System.out.println(selectFlexi.get(i).getText());
		}
		log.debug("*******Testing is being executed on: " + selectFlexi.get(1).getText().trim() + " Screen.*******");
		
	}
	
	public void addBag15kg(int bag){
		logPage();
		if(bag == 0){
			log.debug("*******15kg bag not required*******");
		}else{
			for(int i=0; i<bag; i++){
				plusNumberPickerView.get(0).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusBag15kg(int bag){
		int bagCount = Integer.parseInt(plusNumberPickerView.get(0).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=bagCount; i>bag; i--){
				plusNumberPickerView.get(0).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addBag23kg(int bag){
		logPage();
		if(bag == 0){
			log.debug("*******23kg bag not required*******");
		}else{
			for(int i=0; i<bag; i++){
				plusNumberPickerView.get(1).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusBag23kg(int bag){
		int bagCount = Integer.parseInt(plusNumberPickerView.get(1).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=bagCount; i>bag; i--){
				plusNumberPickerView.get(1).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addSportsEquipBtn(){
		addSportsEquip.click();
	}

	public void passengerDetailsSubmitBtn(){
		passengerDetailsSubmitBtn.click();
	}
	
	public Double getLuggagePrice(){
		logPage();
		List<String> price = new ArrayList<String>();
		List<MobileElement> selectFlexi = linearLayout.get(2).findElementsByClassName("android.widget.TextView");
		for(int i=0; i<selectFlexi.size(); i++){
			price.add(selectFlexi.get(i).getText());
			System.out.println(selectFlexi.get(i).getText());
		}		
		//log.debug("*******Additional Luggage Cost is " + selectFlexi.get(6).getText().trim() +" "+ selectFlexi.get(9).getText().trim() +" "+ selectFlexi.get(11).getText().trim() + selectFlexi.get(12).getText().trim() + ":" + selectFlexi.get(13).getText().trim() + ".*******");
		
		int bagCount15kg = Integer.parseInt(plusNumberPickerView.get(0).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		String luggage15kg = selectFlexi.get(6).getText().trim();
		//log.debug("*******Cost of 15kg Luggage is " + selectFlexi.get(6).getText().trim() + ".*******");
		Double luggage15kgCosts = Double.parseDouble(luggage15kg.replaceAll("[^0-9]",""));
		Double luggages15kg = luggage15kgCosts/100;
		Double luggageTotal15kg = luggages15kg * bagCount15kg * EasyPassengerCountScreen.PassengerCount;
		log.debug("*******Total Calculated 15kg Luggage Cost for total passengers is " + luggageTotal15kg + ".*******");
		
		int bagCount23kg = Integer.parseInt(plusNumberPickerView.get(1).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		//log.debug("*******Cost of 23kg Luggage is " + selectFlexi.get(9).getText().trim() + ".*******");
		String luggage23kg = selectFlexi.get(9).getText().trim();
		Double luggage23kgCosts = Double.parseDouble(luggage23kg.replaceAll("[^0-9]",""));
		Double luggages23kg = luggage23kgCosts/100;
		Double luggageTotal23kg = luggages23kg * bagCount23kg * EasyPassengerCountScreen.PassengerCount;
		log.debug("*******Total Calculated 23kg Luggage Cost for total passengers is " + luggageTotal23kg + ".*******");
		
		String luggageCost = selectFlexi.get(11).getText().trim() + selectFlexi.get(12).getText().trim() + "." + selectFlexi.get(13).getText().trim();
		Double luggageTotalCosts = Double.parseDouble(luggageCost.replaceAll("[^0-9]",""));
		Double luggagesTotal = luggageTotalCosts/100;
		//log.debug(luggagesTotal);
		log.debug("*******Total Luggage Cost (15kg + 23kg) for total passengers is " + luggageCost + ".*******");
		Double calculatedLuggageCosts = luggageTotal15kg+luggageTotal23kg;
		Assert.assertTrue(luggageTotal15kg+luggageTotal23kg==luggagesTotal, "Calculation of Total Additional Luggage is incorrect");
		calculatedLuggageCost=calculatedLuggageCosts;
		return calculatedLuggageCost;
	}
		
	public void finalPrice(){
		String scrollDown = "Final Price";
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+scrollDown+"\").instance(0))");
		
		List<MobileElement> luggagePrice = linearLayout.get(4).findElementsByClassName("android.widget.TextView");
		String luggageCost = luggagePrice.get(1).getText() + luggagePrice.get(2).getText() + "." + luggagePrice.get(3).getText().trim();
		log.debug("*******Luggage Cost is "+ luggageCost +".*******");
		Double luggageCosts = Double.parseDouble(luggageCost.replaceAll("[^0-9]",""));
		Double luggages = luggageCosts/100;
		//log.debug(luggages);
		
		String sportsEquipCost = sportsEquipPrice.getText();
		log.debug("*******Sports Equipment Cost is " + sportsEquipCost +"*******");
		Double sportsCosts = Double.parseDouble(sportsEquipCost.replaceAll("[^0-9]",""));
		Double sports = sportsCosts/100;
		//log.debug(sports);
		
		List<MobileElement> depPricelevel = linearLayout.get(25).findElementsByClassName("android.widget.TextView");
		String outboundFlightCost = depPricelevel.get(1).getText() + depPricelevel.get(2).getText() + "." + depPricelevel.get(3).getText().trim();
		log.debug("*******Outbound Flight Cost is " + outboundFlightCost + ".*******");
		Double outboundCosts = Double.parseDouble(outboundFlightCost.replaceAll("[^0-9]",""));
		Double outbound = outboundCosts/100;
		//log.debug(outbound);		
		
		List<MobileElement> inboundPrice = linearLayout.get(40).findElementsByClassName("android.widget.TextView");
		String inboundFlightCost = inboundPrice.get(1).getText() + inboundPrice.get(2).getText() + "." + inboundPrice.get(3).getText().trim();
		log.debug("*******Inbound Flight Cost is " + inboundFlightCost + ".*******");
		Double inboundCosts = Double.parseDouble(inboundFlightCost.replaceAll("[^0-9]",""));
		Double inbound = inboundCosts/100;
		//log.debug(inbound);
		
		List<MobileElement> totalPrice = linearLayout.get(43).findElementsByClassName("android.widget.TextView");
		String totalCost = totalPrice.get(1).getText() + totalPrice.get(2).getText() + "." + totalPrice.get(3).getText().trim();
		log.debug("*******Total Flight Cost is " + totalCost + ".*******");
		Double totalCosts = Double.parseDouble(totalCost.replaceAll("[^0-9]",""));
		Double total = totalCosts/100;
		//log.debug(total);
		
		Double finalCosts = outbound + inbound + calculatedLuggageCost + EasyTravelSportsEquipmentScreen.calculatedSportsCost;

		BigDecimal big = new BigDecimal(finalCosts);     
        big = big.setScale(2, RoundingMode.HALF_UP);        
        double finalCost = big.doubleValue();
        
		Assert.assertTrue(finalCost==total, "Calculation of Total Travel Cost is incorrect"+ "..." + finalCost + "..." + total);
		
		passengerDetailsSubmitBtn();
	}
	

}
