package screens;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EasyTravelSportsEquipmentScreen extends ScreenBase{
	
	public static Double calculatedSportsCost;

	public static Logger log = Logger.getLogger("devpinoyLogger");
	public EasyTravelSportsEquipmentScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/sport_background_wrapper")
	public List<MobileElement> sportsWrapper;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/plus_btn")
	public List<MobileElement> plusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/minus_btn")
	public List<MobileElement> minusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/count_text")
	public List<MobileElement> countText;
	
	@AndroidFindBy(className="android.widget.TextView")
	public List<MobileElement> textView;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/smallItemCost")
	public MobileElement smallItemEquipCost;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/largeItemCost")
	public MobileElement largeItemEquipCost;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/additionalCost")
	public MobileElement additionalCost;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/submitButton")
	public MobileElement submitButton;
	
	public void addGolfEquipment20kg(int count){
		log.debug("*******Testing is being executed on: " + textView.get(1).getText().trim() + " Screen.*******");
		if(count == 0){
			log.debug("*******Golf Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(0).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusGolfEquipment20kg(int count){
		int equipCount = Integer.parseInt(sportsWrapper.get(0).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=equipCount; i>count; i--){
			sportsWrapper.get(0).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addSkiEquipment20kg(int count){
		if(count == 0){
			log.debug("*******Ski Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(1).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusSkiEquipment20kg(int count){
		int skiCount = Integer.parseInt(sportsWrapper.get(1).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=skiCount; i>count; i--){
			sportsWrapper.get(1).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addSnowboardEquipment20kg(int count){
		if(count == 0){
			log.debug("*******Snow Board Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(2).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusSnowboardEquipment20kg(int count){
		int snowboardCount = Integer.parseInt(sportsWrapper.get(2).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=snowboardCount; i>count; i--){
			sportsWrapper.get(2).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addSportFirearmsEquipment20kg(int count){
		if(count == 0){
			log.debug("*******SportFirearms Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(3).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusSportFirearmsEquipment20kg(int count){
		int sportsFirearmsCount = Integer.parseInt(sportsWrapper.get(3).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=sportsFirearmsCount; i>count; i--){
			sportsWrapper.get(3).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addOtherSmallSportsEquipment20kg(int count){
		if(count == 0){
			log.debug("*******Other Small Sports Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(4).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusOtherSmallSportsEquipment20kg(int count){
		int otherSmallEquipCount = Integer.parseInt(sportsWrapper.get(4).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=otherSmallEquipCount; i>count; i--){
			sportsWrapper.get(4).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addBicycleEquipment32kg(int count){
		if(count == 0){
			log.debug("*******Bicycle Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(5).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusBicycleEquipment20kg(int count){
		int bicycleCount = Integer.parseInt(sportsWrapper.get(5).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=bicycleCount; i>count; i--){
			sportsWrapper.get(5).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addCanoeEquipment32kg(int count){
		if(count == 0){
			log.debug("*******Canoe/Kayak Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(6).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusCanoeEquipment20kg(int count){
		int canoeCount = Integer.parseInt(sportsWrapper.get(6).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=canoeCount; i>count; i--){
			sportsWrapper.get(6).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addWindSurferEquipment32kg(int count){
		if(count == 0){
			log.debug("*******Wind Surfer Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(7).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusWindSurferEquipment20kg(int count){
		int windSurferCount = Integer.parseInt(sportsWrapper.get(7).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=windSurferCount; i>count; i--){
			sportsWrapper.get(7).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addHangGliderEquipment32kg(int count){
		if(count == 0){
			log.debug("*******Hang Glider Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(8).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusHangGliderEquipment20kg(int count){
		int hangGliderCount = Integer.parseInt(sportsWrapper.get(8).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=hangGliderCount; i>count; i--){
			sportsWrapper.get(8).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void smallItemEquipCosts(){
		log.debug("*******"+smallItemEquipCost.getText()+"*******");
//		Double smallItemCost = Double.parseDouble(smallItemEquipCost.getText().replaceAll("[^0-9]",""));
//		Double smallEquipCost = smallItemCost/100;
//		log.debug(smallEquipCost);
	}
	
	public void largeItemEquipCosts(){
		log.debug("*******"+largeItemEquipCost.getText()+"*******");
//		Double largeItemCost = Double.parseDouble(largeItemEquipCost.getText().replaceAll("[^0-9]",""));
//		Double largeEquipCost = largeItemCost/100;
//		log.debug(largeEquipCost);
	}
	
	public void totalSportsEquipAddtionalCost(){
		String totalSportsEquipCost = additionalCost.findElementsByClassName("android.widget.TextView").get(1).getText().trim() + additionalCost.findElementsByClassName("android.widget.TextView").get(2).getText().trim() + "." + additionalCost.findElementsByClassName("android.widget.TextView").get(3).getText().trim();
		log.debug("*******Additional Sports Equipment Cost is " + totalSportsEquipCost + ".*******");
//		Double totalSportsCosts = Double.parseDouble(totalSportsEquipCost.replaceAll("[^0-9]",""));
//		Double totalSports = totalSportsCosts/100;
//		log.debug(totalSports);
	}
	
	public void submitButton(){
		submitButton.click();
	}
	
	public Double validateTotalSportsCost(){
		int equipCount = Integer.parseInt(sportsWrapper.get(0).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		int skiCount = Integer.parseInt(sportsWrapper.get(1).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		int snowboardCount = Integer.parseInt(sportsWrapper.get(2).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		int sportsFirearmsCount = Integer.parseInt(sportsWrapper.get(3).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		int otherSmallEquipCount = Integer.parseInt(sportsWrapper.get(4).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		
		int smallCount = equipCount+skiCount+snowboardCount+sportsFirearmsCount+otherSmallEquipCount;
		
		Double smallItemCost = Double.parseDouble(smallItemEquipCost.getText().replaceAll("[^0-9]",""));
		Double smallEquipCost = smallItemCost/100;
		Double smallEquip20kgCost = smallEquipCost * smallCount;
		//log.debug(smallEquip20kgCost);
		
		int bicycleCount = Integer.parseInt(sportsWrapper.get(5).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		int canoeCount = Integer.parseInt(sportsWrapper.get(6).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		int windSurferCount = Integer.parseInt(sportsWrapper.get(7).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		int hangGliderCount = Integer.parseInt(sportsWrapper.get(8).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		
		int largeCount = bicycleCount+canoeCount+windSurferCount+hangGliderCount;
		
		Double largeItemCost = Double.parseDouble(largeItemEquipCost.getText().replaceAll("[^0-9]",""));
		Double largeEquipCost = largeItemCost/100;
		Double smallEquip32kgCost = largeEquipCost * largeCount;
		//log.debug(smallEquip32kgCost);
		
		String totalSportsEquipCost = additionalCost.findElementsByClassName("android.widget.TextView").get(1).getText().trim() + additionalCost.findElementsByClassName("android.widget.TextView").get(2).getText().trim() + "." + additionalCost.findElementsByClassName("android.widget.TextView").get(3).getText().trim();
		Double totalSportsCosts = Double.parseDouble(totalSportsEquipCost.replaceAll("[^0-9]",""));
		Double totalSports = totalSportsCosts/100;
		//log.debug(totalSports);
		
		Double calculatedLuggageCosts = smallEquip20kgCost+smallEquip32kgCost;
		Assert.assertTrue(smallEquip20kgCost+smallEquip32kgCost==totalSports, "Calculation of Total Sports Equipment is incorrect");
		//log.debug(smallEquip20kgCost+smallEquip32kgCost);
		calculatedSportsCost=calculatedLuggageCosts;
		return calculatedSportsCost;
	}
	
	public void addSportsEquipment(int GolfCount, int SkiCount, int SnowBoardCount, int FirearmsCount, int SmallEquipCount, int BicycleCount, int CanoeCount, int WindSurferCount, int HangGliderCount){
		addGolfEquipment20kg(GolfCount);
		addSkiEquipment20kg(SkiCount);
		addSnowboardEquipment20kg(SnowBoardCount);
		addSportFirearmsEquipment20kg(FirearmsCount);
		addOtherSmallSportsEquipment20kg(SmallEquipCount);
		addBicycleEquipment32kg(BicycleCount);
		addCanoeEquipment32kg(CanoeCount);
		addWindSurferEquipment32kg(WindSurferCount);
		addHangGliderEquipment32kg(HangGliderCount);
		totalSportsEquipAddtionalCost();
		validateTotalSportsCost();
		submitButton();
	}

}
